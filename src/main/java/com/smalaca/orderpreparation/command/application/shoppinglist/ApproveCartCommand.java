package com.smalaca.orderpreparation.command.application.shoppinglist;

import java.util.List;
import java.util.UUID;

import com.smalaca.orderpreparation.command.domain.shoppinglist.Product;

import lombok.Value;

@Value(staticConstructor = "of")
public class ApproveCartCommand {

    private final UUID customer;

    private final UUID cartId;

    private final List<Product> products;

}
