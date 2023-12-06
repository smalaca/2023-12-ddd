package com.smalaca.orderpreparation.command.domain.order;

import java.util.List;

import com.smalaca.annotation.ddd.DomainEvent;
import com.smalaca.orderpreparation.sharedkernel.Product;

import lombok.Value;

@DomainEvent
@Value(staticConstructor = "of")
public class ProductUnavailableEvent {

    private final List<Product> products;
}
