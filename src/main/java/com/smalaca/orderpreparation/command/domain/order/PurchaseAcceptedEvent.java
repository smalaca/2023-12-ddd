package com.smalaca.orderpreparation.command.domain.order;

import com.smalaca.annotation.ddd.DomainEvent;

import lombok.Value;

@DomainEvent
@Value(staticConstructor = "of")
public class PurchaseAcceptedEvent {

    private final Object products;

}
