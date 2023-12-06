package com.smalaca.basket.command.domain.basket;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;

@AggregateRoot
public class Basket {
    @PrimaryPort
    public void addProduct() {

    }

    @PrimaryPort
    public void removeProduct() {

    }
}
