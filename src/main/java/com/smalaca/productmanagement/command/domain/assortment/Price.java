package com.smalaca.productmanagement.command.domain.assortment;

import com.smalaca.annotation.ddd.ValueObject;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@ValueObject
@Embeddable
public class Price {
    private final BigDecimal value;

    public Price(BigDecimal value) {
        this.value = value;
    }

    BigDecimal value() {
        return value;
    }
}
