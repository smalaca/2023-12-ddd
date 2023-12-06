package com.smalaca.orderpreparation.command.domain.product;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.annotation.ddd.ValueObject;

import java.util.Map;
import java.util.UUID;

@ValueObject
public class Product {
    private final UUID productId;
    private final Amount amount;

    private Product(UUID productId, Amount amount) {
        this.productId = productId;
        this.amount = amount;
    }

    @Factory
    public static Product create(UUID productId, Integer amount) {
        return new Product(productId, new Amount(amount));
    }

    public void addTo(Map<UUID, Integer> products) {
        products.put(productId, amount.value());
    }
}
