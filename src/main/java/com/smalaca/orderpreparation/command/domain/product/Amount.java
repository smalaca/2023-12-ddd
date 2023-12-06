package com.smalaca.orderpreparation.command.domain.product;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
class Amount {
    private final Integer value;

    Amount(Integer value) {
        this.value = value;
    }

    Integer value() {
        return value;
    }
}
