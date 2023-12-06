package com.smalaca.orderpreparation.command.domain.shopping;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.command.domain.disposal.AcceptShoppingDomainCommand;
import com.smalaca.orderpreparation.command.domain.disposal.Disposal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AggregateRoot
public class Shopping {
    private UUID shoppingId;
    private final List<Product> products = new ArrayList<>();

    @PrimaryPort
    @Factory
    public Disposal accept(AcceptShoppingDomainCommand command) {
        return new Disposal(shoppingId, products, command);
    }
}
