package com.smalaca.orderpreparation.command.domain.producttoorder;

import java.util.List;
import java.util.UUID;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.eventbus.EventBus;
import com.smalaca.orderpreparation.command.application.producttoorder.ApproveCartCommand;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AggregateRoot
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductsToOrder {

    @NotNull
    private UUID id;

    public static ProductsToOrder of(final UUID id) {
        return new ProductsToOrder(id);
    }

    public void approve(final EventBus eventBus, final List<Object> products) {
        // todo dodanie produktów do agregatu
        eventBus.fire(ProductsSelectedEvent.of(products));
    }

}
