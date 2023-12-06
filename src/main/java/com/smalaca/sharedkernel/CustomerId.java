package com.smalaca.sharedkernel;

import java.util.UUID;

import com.smalaca.annotation.ddd.ValueObject;

import lombok.Value;

@ValueObject
@Value(staticConstructor = "of")
public class CustomerId {

    private final UUID id;

}
