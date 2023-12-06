package com.smalaca.orderpreparation.command.domain.disposal;

import com.smalaca.annotation.ddd.AggregateRoot;

@AggregateRoot
public class Disposal {
    private final DeliveryType deliveryType;
    private final Address address;

    public Disposal(AcceptShoppingDomainCommand command) {
        this.deliveryType = command.deliveryType();
        this.address = command.address();
    }
}
