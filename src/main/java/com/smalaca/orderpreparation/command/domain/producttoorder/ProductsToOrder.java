package com.smalaca.orderpreparation.command.domain.producttoorder;

import java.util.UUID;

import com.smalaca.annotation.ddd.AggregateRoot;

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

    public void approve(final Object cart) {

    }

}
