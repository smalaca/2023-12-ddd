package com.smalaca.productmanagement.command.domain.assortment;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;

@AggregateRoot
public class Assortment {

    @PrimaryPort
    public void addProduct(Amount amount) {

    }
}
