package com.smalaca.orderpreparation.command.domain.order;

import lombok.Value;

import com.smalaca.annotation.ddd.DomainEvent;

@DomainEvent
@Value(staticConstructor = "of")
public class PurchaseAcceptedEvent {

    private final Object products;

}
