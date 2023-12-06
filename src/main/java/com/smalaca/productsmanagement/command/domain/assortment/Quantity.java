package com.smalaca.productsmanagement.command.domain.assortment;

import com.smalaca.annotation.ddd.ValueObject;

import lombok.Value;

@ValueObject
@Value(staticConstructor = "of")
public class Quantity {

    private final int value;

}