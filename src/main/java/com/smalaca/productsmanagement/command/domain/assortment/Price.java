package com.smalaca.productsmanagement.command.domain.assortment;

import java.math.BigDecimal;

import com.smalaca.annotation.ddd.ValueObject;

import lombok.Value;

// TODO possible shared kernel ?
@ValueObject
@Value(staticConstructor = "of")
public class Price {

    private final BigDecimal amount;

    private final String currency;

}
