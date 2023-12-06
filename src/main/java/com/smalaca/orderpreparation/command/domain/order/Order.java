package com.smalaca.orderpreparation.command.domain.order;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

import com.smalaca.annotation.ddd.AggregateRoot;

@Getter
@AggregateRoot
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {

    @NotNull
    private UUID id;

    public static Order of(final UUID id) {
        return new Order(id);
    }

    public void acceptProducts(final Object products) {

    }

}
