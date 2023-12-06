package com.smalaca.orderpreparation.command.domain.shoppinglist;

import com.smalaca.annotation.ddd.DomainEvent;

import lombok.Value;

@DomainEvent
@Value(staticConstructor = "of")
public class ProductsSelectedEvent {

    private final Object products;
}
