package com.smalaca.productmanagement.command.domain.assortment;

import com.smalaca.annotation.ddd.ValueObject;

import java.math.BigDecimal;

@ValueObject
public class Price {
    private final BigDecimal value;

    public Price(BigDecimal value) {
        this.value = value;
    }

    BigDecimal value() {
        return value;
    }
}
