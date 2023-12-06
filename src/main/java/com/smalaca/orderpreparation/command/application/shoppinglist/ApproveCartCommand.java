package com.smalaca.orderpreparation.command.application.shoppinglist;

import java.util.List;

import com.smalaca.orderpreparation.sharedkernel.Product;
import com.smalaca.sharedkernel.CustomerId;

import lombok.Value;

@Value(staticConstructor = "of")
public class ApproveCartCommand {

    private final CustomerId customer;

    private final List<Product> products;

}
