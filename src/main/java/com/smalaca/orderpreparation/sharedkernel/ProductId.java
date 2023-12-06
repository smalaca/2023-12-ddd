package com.smalaca.orderpreparation.sharedkernel;

import java.util.UUID;

import com.smalaca.annotation.ddd.ValueObject;

import lombok.Value;

@ValueObject
@Value(staticConstructor = "of")
public class ProductId {

    private final UUID id;

}
