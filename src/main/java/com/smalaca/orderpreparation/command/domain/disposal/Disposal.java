package com.smalaca.orderpreparation.command.domain.disposal;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.orderpreparation.command.domain.deliverytype.DeliveryType;

@AggregateRoot
public class Disposal {
    private final DeliveryType deliveryType;

    public Disposal(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
}
