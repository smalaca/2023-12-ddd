package com.smalaca.productmanagement.command.domain.assortment;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.HashMap;
import java.util.Map;

@AggregateRoot
public class Assortment {
    private Map<Product, Amount> products = new HashMap<>();

    @PrimaryPort
    public void addProduct(Amount amount, Price price) {
        products.put(new Product(price), amount);
    }
}
