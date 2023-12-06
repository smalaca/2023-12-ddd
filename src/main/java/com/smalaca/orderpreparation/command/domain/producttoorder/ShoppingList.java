package com.smalaca.orderpreparation.command.domain.producttoorder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.eventbus.EventBus;
import com.smalaca.orderpreparation.command.domain.order.Order;
import com.smalaca.orderpreparation.command.domain.order.ProductUnavailableEvent;
import com.smalaca.orderpreparation.command.domain.order.ProductsAvailabilityValidator;
import com.smalaca.orderpreparation.command.domain.order.ProductsReservationService;
import com.smalaca.orderpreparation.command.domain.order.PurchaseAcceptedEvent;
import com.smalaca.validation.ValidatorExecutor;

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

    @NotEmpty
    private final List<Object> products;

    public static ShoppingList of(final UUID id, final List<Object> products, final EventBus eventBus) {
        ShoppingList shoppingList = ValidatorExecutor.validateAndReturn(new ShoppingList(id, products));
        eventBus.fire(ProductsSelectedEvent.of(products));
        return shoppingList;
    }

    public Optional<Order> acceptProducts(final UUID orderId, final EventBus eventBus,
                                          final ProductsReservationService productsReservationService,
                                          final ProductsAvailabilityValidator productsAvailabilityValidator) {
        if(productsAvailabilityValidator.validate()) {
            eventBus.fire(ProductUnavailableEvent.of(products));
            return Optional.empty();
        }
        productsReservationService.book(List.of());
        eventBus.fire(PurchaseAcceptedEvent.of(products));
        return Optional.of(Order.of(orderId));
    }

}
