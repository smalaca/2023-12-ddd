package com.smalaca.orderpreparation.command.domain.shoppinglist;

import java.util.List;

import com.smalaca.annotation.ddd.DomainEvent;
import com.smalaca.orderpreparation.sharedkernel.Product;

import lombok.Value;

@DomainEvent
@Value(staticConstructor = "of")
public class ProductsSelectedEvent {

    private final List<Product> products;
}
