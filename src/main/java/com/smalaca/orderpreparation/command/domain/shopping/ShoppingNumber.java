package com.smalaca.orderpreparation.command.domain.shopping;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.annotation.ddd.ValueObject;

import java.util.UUID;

@ValueObject
class ShoppingNumber {
    private final String value;

    private ShoppingNumber(String value) {
        this.value = value;
    }

    @Factory
    static ShoppingNumber create(UUID buyerId) {
        return new ShoppingNumber(buyerId + "-" + UUID.randomUUID());
    }
}
