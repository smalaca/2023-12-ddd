package com.smalaca.orderpreparation.command.domain.order;

import java.util.List;

import com.smalaca.annotation.ddd.DomainEvent;
import com.smalaca.orderpreparation.sharedcernel.Product;

import lombok.Value;

@DomainEvent
@Value(staticConstructor = "of")
public class PurchaseAcceptedEvent {

    private final List<Product> products;

}
