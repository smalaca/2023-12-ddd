package com.smalaca.orderpreparation.command.domain.order;

import com.smalaca.annotation.ddd.ValueObject;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

@ValueObject
@Value(staticConstructor = "of")
public class DeliveryInfo {

    @NotNull
    private final Address address;

    @NotNull
    private final DeliveryType type;

}
