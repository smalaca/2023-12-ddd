package com.smalaca.orderpreparation.command.domain.order;

import java.time.LocalDateTime;
import java.util.List;

import com.smalaca.annotation.ddd.DomainEvent;
import com.smalaca.orderpreparation.sharedkernel.Product;
import com.smalaca.sharedkernel.CustomerId;
import com.smalaca.sharedkernel.domain.eventbus.EventId;

import lombok.Value;

@DomainEvent
@Value(staticConstructor = "of")
public class ProductsNotFoundEvent {

    private final EventId id;

    private final LocalDateTime occurrenceTime;

    private final CustomerId customer;

    private final List<Product> products;

}
