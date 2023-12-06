package com.smalaca.productsmanagement.command.domain.assortment;

import com.smalaca.annotation.ddd.ValueObject;

import lombok.Value;

// TODO possible shared kernel ?
@ValueObject
@Value(staticConstructor = "of")
public class Quantity {

    private final int value;

}