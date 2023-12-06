package com.smalaca.orderpreparation.command.domain.order;

import com.smalaca.annotation.ddd.ValueObject;

import jakarta.validation.constraints.NotEmpty;
import lombok.Value;

@ValueObject
@Value(staticConstructor = "of")
public class Address {

    @NotEmpty
    private final String town;

    @NotEmpty
    private final String street;

    @NotEmpty
    private final String number;

}
