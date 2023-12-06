package com.smalaca.productmanagement.command.domain.assortment;

import com.smalaca.annotation.ddd.DomainEntity;

@DomainEntity
class Product {
    private final String name;
    private final Price price;
    private final String description;

    Product(String name, Price price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
