package com.smalaca.orderpreparation.command.domain.disposal;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class DeliveryType {
    private final String value;

    public DeliveryType(String value) {
        this.value = value;
    }
}
