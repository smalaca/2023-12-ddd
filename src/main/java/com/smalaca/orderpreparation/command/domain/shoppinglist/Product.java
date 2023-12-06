package com.smalaca.orderpreparation.command.domain.shoppinglist;

import java.util.UUID;

import com.smalaca.annotation.ddd.ValueObject;
import com.smalaca.productsmanagement.command.domain.assortment.Quantity;

import lombok.Value;

@ValueObject
@Value(staticConstructor = "of")
public class Product {

    private final UUID id;

    private final Quantity quantity;

}
