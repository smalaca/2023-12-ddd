package com.smalaca.orderpreparation.command.application.producttoorder;

import java.util.List;
import java.util.UUID;

import lombok.Value;

@Value(staticConstructor = "of")
public class ApproveCartCommand {

    private final UUID cartId;

    private final List<Object> products;

}
