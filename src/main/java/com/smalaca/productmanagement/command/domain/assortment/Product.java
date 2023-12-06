package com.smalaca.productmanagement.command.domain.assortment;

import com.smalaca.annotation.ddd.DomainEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@DomainEntity
@Entity
class Product {
    @Id
    @GeneratedValue
    private UUID productId;
    private final String name;
    @Embedded
    private final Price price;
    private final String description;

    Product(String name, Price price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
