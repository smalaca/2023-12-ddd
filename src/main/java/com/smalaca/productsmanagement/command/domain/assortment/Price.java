package com.smalaca.productsmanagement.command.domain.assortment;

import java.math.BigDecimal;

import com.smalaca.annotation.ddd.ValueObject;

import lombok.Value;

@ValueObject
@Value(staticConstructor = "of")
public class Price {

    private final BigDecimal amount;

    private final String currency;

}
