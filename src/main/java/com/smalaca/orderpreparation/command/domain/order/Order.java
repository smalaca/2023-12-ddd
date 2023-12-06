package com.smalaca.orderpreparation.command.domain.order;

import java.util.List;
import java.util.UUID;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.eventbus.EventBus;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AggregateRoot
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {

    @NotNull
    private UUID id;

    public static Order of(final UUID id) {
        return new Order(id);
    }

    public void acceptProducts(final EventBus eventBus,
                               final ProductsReservationService productsReservationService,
                               final ProductsAvailabilityValidator productsAvailabilityValidator,
                               final Object products) {
        if(productsAvailabilityValidator.validate()) {
            eventBus.fire(ProductUnavailableEvent.of(products));
            return;
        }
        productsReservationService.book(List.of());
        eventBus.fire(PurchaseAcceptedEvent.of(products));
    }

}
