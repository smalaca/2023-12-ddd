package com.smalaca.orderpreparation.command.domain.product;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.annotation.ddd.ValueObject;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

@ValueObject
public class Product {
    private final UUID productId;
    private final Amount amount;
    private final Price price;

    private Product(UUID productId, Amount amount, Price price) {
        this.productId = productId;
        this.amount = amount;
        this.price = price;
    }

    @Factory
    public static Product create(UUID productId, Integer amount, BigDecimal price) {
        return new Product(productId, new Amount(amount), new Price(price));
    }

    public void addTo(Map<UUID, Integer> products) {
        products.put(productId, amount.value());
    }
}
