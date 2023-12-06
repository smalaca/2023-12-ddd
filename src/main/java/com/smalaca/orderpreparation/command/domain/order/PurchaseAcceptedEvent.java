package com.smalaca.orderpreparation.command.domain.order;

import java.util.List;

import com.smalaca.annotation.ddd.DomainEvent;
import com.smalaca.orderpreparation.sharedkernel.ChosenProduct;
import com.smalaca.sharedkernel.CustomerId;
import com.smalaca.sharedkernel.domain.eventbus.EventId;

import lombok.Value;

@DomainEvent
@Value(staticConstructor = "of")
public class PurchaseAcceptedEvent {

    private final EventId id;

    private final CustomerId customer;

    private final List<ChosenProduct> products;

}
