package com.smalaca.orderpreparation.command.domain.shoppinglist;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.command.application.order.AcceptProductsCommand;
import com.smalaca.orderpreparation.command.domain.order.Order;
import com.smalaca.orderpreparation.command.domain.order.ProductsNotFoundEvent;
import com.smalaca.orderpreparation.command.domain.order.PurchaseAcceptedEvent;
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
    public Optional<Order> accept(final AcceptParamsWrapper paramsWrapper) {
        if(paramsWrapper.getProductsAvailabilityValidator().isInvalid(toProducts(products))) {
            unavailableProducts(paramsWrapper);
            return Optional.empty();
        }
        return Optional.of(createOrder(paramsWrapper));
    }

    private void unavailableProducts(final AcceptParamsWrapper paramsWrapper) {
        CustomerId customer = paramsWrapper.getCustomer();
        LocalDateTime occurrenceTime = paramsWrapper.getTimeProvider().currentTime();
        paramsWrapper.getEventBus().fire(ProductsNotFoundEvent.of(EventId.of(), occurrenceTime, customer, toProducts(products)));
    }

    private Order createOrder(final AcceptParamsWrapper wrapper) {
        AcceptProductsCommand.AcceptParams params = wrapper.getParams();
        CustomerId customer = wrapper.getCustomer();
        LocalDateTime occurrenceTime = wrapper.getTimeProvider().currentTime();

        wrapper.getProductsReservationService().book(toProducts(products));
        wrapper.getEventBus().fire(PurchaseAcceptedEvent.of(EventId.of(), occurrenceTime, customer, products));
        return Order.of(wrapper.getOrderId(), id, customer, wrapper.getRandomNumberGenerator(), params.getDeliveryInfo(), params.getPaymentType(), products);
    }

    private static List<Product> toProducts(final List<ChosenProduct> products) {
        return products.stream()
                       .map(product -> Product.of(product.getId(), product.getQuantity()))
                       .collect(Collectors.toList());
    }

}
