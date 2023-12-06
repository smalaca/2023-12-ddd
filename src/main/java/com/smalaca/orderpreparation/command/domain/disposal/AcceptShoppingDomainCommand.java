package com.smalaca.orderpreparation.command.domain.disposal;

public record AcceptShoppingDomainCommand(DeliveryType deliveryType, Address address, PaymentType paymentType) {
}
