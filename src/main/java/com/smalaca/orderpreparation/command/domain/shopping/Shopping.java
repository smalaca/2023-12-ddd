package com.smalaca.orderpreparation.command.domain.shopping;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.command.domain.disposal.Disposal;

@AggregateRoot
public class Shopping {
    @PrimaryPort
    @Factory
    public Disposal accept(AcceptShoppingDomainCommand command) {
        return new Disposal(command.deliveryType());
    }
}
