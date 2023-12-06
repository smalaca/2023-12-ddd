package com.smalaca.orderpreparation.command.domain.shoppinglist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.eventbus.EventBus;
import com.smalaca.orderpreparation.command.application.order.AcceptProductsCommand;
import com.smalaca.orderpreparation.command.domain.order.Order;
import com.smalaca.orderpreparation.command.domain.order.ProductUnavailableEvent;
import com.smalaca.orderpreparation.command.domain.order.ProductsAvailabilityValidator;
import com.smalaca.orderpreparation.command.domain.order.ProductsReservationService;
import com.smalaca.orderpreparation.command.domain.order.PurchaseAcceptedEvent;
import com.smalaca.validation.ValidatorExecutor;

import jakarta.validation.constraints.NotBlank;
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
    private UUID id;

    @NotBlank
    private String number;

    @NotEmpty
    private final List<Product> products;

    @Factory
    public static ShoppingList of(final UUID id, final UUID customer, final List<Product> products, final EventBus eventBus) {
        ShoppingList shoppingList = ValidatorExecutor.validateAndReturn(new ShoppingList(id, customer.toString() + UUID.randomUUID(), products));
        eventBus.fire(ProductsSelectedEvent.of(products));
        return shoppingList;
    }

    @PrimaryPort
    public Optional<Order> accept(final UUID orderId,
                                  final UUID customer,
                                  final AcceptProductsCommand.AcceptParams params,
                                  final EventBus eventBus,
                                  final ProductsReservationService productsReservationService,
                                  final ProductsAvailabilityValidator productsAvailabilityValidator) {
        if(productsAvailabilityValidator.validate()) {
            eventBus.fire(ProductUnavailableEvent.of(products));
            return Optional.empty();
        }
        productsReservationService.book(List.of());
        eventBus.fire(PurchaseAcceptedEvent.of(products));
        return Optional.of(Order.of(orderId, id, customer, params.getAddress(), params.getDeliveryType(), params.getPaymentType(), products));
    }

}
