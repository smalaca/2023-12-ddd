package com.smalaca.orderpreparation.command.domain.disposal;

import com.smalaca.orderpreparation.command.domain.eventpublisher.EventPublisher;
import com.smalaca.orderpreparation.command.domain.productmanagement.ProductManagement;

public record AcceptShoppingDomainCommand(
        DeliveryType deliveryType, Address address, PaymentType paymentType, ProductManagement productManagement,
        EventPublisher eventPublisher) {
}
