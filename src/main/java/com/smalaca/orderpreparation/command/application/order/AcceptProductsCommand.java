package com.smalaca.orderpreparation.command.application.order;

import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class AcceptProductsCommand {

    private final UUID productsToOrderId;

}
