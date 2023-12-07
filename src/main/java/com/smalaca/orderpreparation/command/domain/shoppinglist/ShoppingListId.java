package com.smalaca.orderpreparation.command.domain.shoppinglist;

import java.util.UUID;

import com.smalaca.annotation.ddd.ValueObject;

import lombok.Value;

@ValueObject
@Value(staticConstructor = "of")
public class ShoppingListId {

    private final UUID id;

}
