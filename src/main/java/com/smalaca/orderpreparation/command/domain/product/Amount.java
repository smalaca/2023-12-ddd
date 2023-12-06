package com.smalaca.orderpreparation.command.domain.product;

import lombok.Value;

@Value
class Amount {
    private final Integer amount;

    Amount(Integer amount) {
        this.amount = amount;
    }
}
