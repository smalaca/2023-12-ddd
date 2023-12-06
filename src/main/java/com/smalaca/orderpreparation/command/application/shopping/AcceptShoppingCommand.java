package com.smalaca.orderpreparation.command.application.shopping;

import com.smalaca.orderpreparation.command.domain.deliverytype.DeliveryType;
import com.smalaca.orderpreparation.command.domain.shopping.AcceptShoppingDomainCommand;

import java.util.UUID;

public record AcceptShoppingCommand(UUID shoppingId, String deliveryType) {
    AcceptShoppingDomainCommand asAcceptShoppingDomainCommand() {
        return new AcceptShoppingDomainCommand(
                new DeliveryType(deliveryType)
        );
    }
}
