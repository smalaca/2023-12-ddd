package com.smalaca.orderpreparation.command.domain.shoppinglist;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.command.application.order.AcceptProductsCommand;
import com.smalaca.orderpreparation.command.domain.order.Order;
import com.smalaca.orderpreparation.command.domain.order.OrderId;
import com.smalaca.orderpreparation.command.domain.order.OrderNumber;
import com.smalaca.orderpreparation.command.domain.order.ProductsNotFoundEvent;
import com.smalaca.orderpreparation.command.domain.order.PurchaseAcceptedEvent;
import com.smalaca.orderpreparation.command.domain.products.ProductsAvailabilityValidator;
import com.smalaca.orderpreparation.command.domain.products.ProductsReservationService;
import com.smalaca.orderpreparation.sharedkernel.ChosenProduct;
import com.smalaca.orderpreparation.sharedkernel.Product;
import com.smalaca.sharedkernel.CustomerId;
import com.smalaca.sharedkernel.domain.eventbus.EventBus;
import com.smalaca.sharedkernel.domain.eventbus.EventId;
import com.smalaca.validation.ValidatorExecutor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AggregateRoot
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ShoppingList {

    @NotNull
    private ShoppingListId id;

    @Valid
    @NotNull
    private ShoppingListNumber number;

    @NotEmpty
    private final List<ChosenProduct> products;

    @Factory
    public static ShoppingList of(final ShoppingListId id, final ShoppingListNumber number, final List<ChosenProduct> products, final EventBus eventBus) {
        ShoppingList shoppingList = ValidatorExecutor.validateAndReturn(new ShoppingList(id, number, products));
        eventBus.fire(ProductsSelectedEvent.of(toProducts(products)));
        return shoppingList;
    }

    @Factory
    @PrimaryPort
    public Optional<Order> accept(final OrderId orderId,
                                  final Function<CustomerId, OrderNumber> randomNumberGenerator,
                                  final CustomerId customer,
                                  final AcceptProductsCommand.AcceptParams params,
                                  final EventBus eventBus,
                                  final ProductsReservationService productsReservationService,
                                  final ProductsAvailabilityValidator productsAvailabilityValidator) {
        if(productsAvailabilityValidator.isInvalid(toProducts(products))) {
            eventBus.fire(ProductsNotFoundEvent.of(EventId.of(), customer, toProducts(products)));
            return Optional.empty();
        }
        productsReservationService.book(toProducts(products));
        eventBus.fire(PurchaseAcceptedEvent.of(EventId.of(), customer, products));
        Order order = Order.of(orderId, id, customer, randomNumberGenerator, params.getDeliveryInfo(), params.getPaymentType(), products);
        return Optional.of(order);
    }

    private static List<Product> toProducts(final List<ChosenProduct> products) {
        return products.stream()
                       .map(product -> Product.of(product.getId(), product.getQuantity()))
                       .collect(Collectors.toList());
    }

}
