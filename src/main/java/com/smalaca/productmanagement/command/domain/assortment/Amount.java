package com.smalaca.productmanagement.command.domain.assortment;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class Amount {
    private final int value;

    public Amount(int amount) {
        this.value = amount;
    }
}
