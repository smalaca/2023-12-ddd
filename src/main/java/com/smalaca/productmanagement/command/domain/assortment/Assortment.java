package com.smalaca.productmanagement.command.domain.assortment;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@AggregateRoot
public class Assortment {
    private UUID assortmentId;
    private UUID sellerId;
    private Map<Product, Amount> products = new HashMap<>();

    @PrimaryPort
    public void addProduct(Amount amount, Price price, String name, String description) {
        Product product = new Product(name, price, description);

        products.put(product, amount);
    }
}
