package com.smalaca.orderpreparation.command.application.shoppinglist;

import java.util.List;
import java.util.UUID;

import com.smalaca.orderpreparation.sharedcernel.Product;
import com.smalaca.sharedcernel.CustomerId;

import lombok.Value;

@Value(staticConstructor = "of")
public class ApproveCartCommand {

    private final CustomerId customer;

    private final UUID cartId;

    private final List<Product> products;

}
