package com.smalaca.orderpreparation.command.domain.order;

import com.smalaca.annotation.ddd.ValueObject;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@ValueObject
@Value(staticConstructor = "of")
public class OrderNumber {

    @NotBlank
    private final String number;

}
