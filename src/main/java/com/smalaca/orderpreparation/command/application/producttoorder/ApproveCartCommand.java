package com.smalaca.orderpreparation.command.application.producttoorder;

import java.util.UUID;

import lombok.Value;

@Value(staticConstructor = "of")
public class ApproveCartCommand {

    private final UUID cartId;

}
