package com.smalaca.orderpreparation.command.domain.product;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
class Amount {
    private final Integer amount;

    Amount(Integer amount) {
        this.amount = amount;
    }
}
