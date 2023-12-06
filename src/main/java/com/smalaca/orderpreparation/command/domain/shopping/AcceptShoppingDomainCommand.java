package com.smalaca.orderpreparation.command.domain.shopping;

import com.smalaca.orderpreparation.command.domain.deliverytype.DeliveryType;

public record AcceptShoppingDomainCommand(DeliveryType deliveryType) {
}
