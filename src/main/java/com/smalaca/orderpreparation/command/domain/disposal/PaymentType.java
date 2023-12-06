package com.smalaca.orderpreparation.command.domain.disposal;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class PaymentType {
    private final String value;

    public PaymentType(String value) {
        this.value = value;
    }
}
