package com.smalaca.orderpreparation.command.domain.shopping;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.command.domain.product.Product;

import java.util.List;

@Factory
public class ShoppingFactory {
    public Shopping create(List<Product> products) {
        return new Shopping(products);
    }
}
