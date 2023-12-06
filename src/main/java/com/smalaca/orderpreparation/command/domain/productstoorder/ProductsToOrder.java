package com.smalaca.orderpreparation.command.domain.productstoorder;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.command.domain.offer.Offer;

@AggregateRoot
public class ProductsToOrder {
    @PrimaryPort
    @Factory
    public Offer accept() {
        return null;
    }
}
