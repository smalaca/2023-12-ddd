package com.smalaca.orderpreparation.command.domain.order;

import java.util.UUID;

import com.smalaca.annotation.ddd.ValueObject;

import lombok.Value;

@ValueObject
@Value(staticConstructor = "of")
public class OrderId {

    private final UUID id;

}
