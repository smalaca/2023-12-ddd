package com.smalaca.orderpreparation.command.application.order;

import java.util.UUID;

import lombok.Value;

@Value(staticConstructor = "of")
public class AcceptProductsCommand {

    private final UUID productsToOrderId;

}
