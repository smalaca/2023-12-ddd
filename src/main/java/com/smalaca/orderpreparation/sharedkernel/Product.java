package com.smalaca.orderpreparation.sharedkernel;

import java.util.UUID;

import com.smalaca.annotation.ddd.ValueObject;
import com.smalaca.productsmanagement.command.domain.assortment.Quantity;

import lombok.Value;

// todo maybe not shared kernel, product in order != shopping list
@ValueObject
@Value(staticConstructor = "of")
public class Product {

    private final UUID id;

    private final Quantity quantity;

}
