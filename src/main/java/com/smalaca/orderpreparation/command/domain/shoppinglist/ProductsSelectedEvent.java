package com.smalaca.orderpreparation.command.domain.shoppinglist;

import java.time.LocalDateTime;
import java.util.List;

import com.smalaca.annotation.ddd.DomainEvent;
import com.smalaca.orderpreparation.sharedkernel.Product;
import com.smalaca.sharedkernel.domain.eventbus.EventId;

import lombok.Value;

@DomainEvent
@Value(staticConstructor = "of")
public class ProductsSelectedEvent {

    private final EventId id;

    private final LocalDateTime occurrenceTime;

    private final List<Product> products;
}
