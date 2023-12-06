package com.smalaca.orderpreparation.command.domain.shopping;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.command.domain.product.Product;
import com.smalaca.orderpreparation.command.domain.productmanagement.ProductManagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Factory
public class ShoppingFactory {
    private final ProductManagement productManagement;

    ShoppingFactory(ProductManagement productManagement) {
        this.productManagement = productManagement;
    }

    public Shopping create(UUID buyerId, Map<UUID, Integer> choice) {
        Map<UUID, BigDecimal> prices = productManagement.priceFor(choice.keySet());

        List<Product> products = new ArrayList<>();

        choice.forEach((id, amount) -> {
            Product product = Product.create(id, amount, prices.get(id));
            products.add(product);
        });

        return new Shopping(shoppingNumber(buyerId), products);
    }

    private ShoppingNumber shoppingNumber(UUID buyerId) {
        return ShoppingNumber.create(buyerId);
    }


}
