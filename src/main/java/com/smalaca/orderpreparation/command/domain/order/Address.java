package com.smalaca.orderpreparation.command.domain.order;

import com.smalaca.annotation.ddd.ValueObject;

import lombok.Value;

@ValueObject
@Value(staticConstructor = "of")
public class Address {

    private final String town;

    private final String street;

    private final String number;

}
