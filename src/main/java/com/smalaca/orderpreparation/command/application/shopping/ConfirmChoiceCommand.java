package com.smalaca.orderpreparation.command.application.shopping;

import com.smalaca.orderpreparation.command.domain.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public record ConfirmChoiceCommand(Map<UUID, Integer> products) {
    List<Product> asProducts() {
        List<Product> products = new ArrayList<>();

        this.products.forEach((id, amount) -> {
            Product product = Product.create(id, amount);
            products.add(product);
        });

        return products;
    }
}
