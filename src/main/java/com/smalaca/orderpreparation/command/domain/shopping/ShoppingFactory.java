package com.smalaca.orderpreparation.command.domain.shopping;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.command.domain.product.Product;

import java.util.List;
import java.util.UUID;

@Factory
public class ShoppingFactory {
    public Shopping create(UUID buyerId, List<Product> products) {
        return new Shopping(shoppingNumber(buyerId), products);
    }

    private ShoppingNumber shoppingNumber(UUID buyerId) {
        return ShoppingNumber.create(buyerId);
    }


}
