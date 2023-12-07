package com.smalaca.orderpreparation.command.domain.shoppinglist;

import com.smalaca.annotation.ddd.ValueObject;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@ValueObject
@Value(staticConstructor = "of")
public class ShoppingListNumber {

    @NotBlank
    private final String number;

}
