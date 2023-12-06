package com.smalaca.orderpreparation.command.application.shopping;

import com.smalaca.orderpreparation.command.domain.disposal.Address;
import com.smalaca.orderpreparation.command.domain.disposal.DeliveryType;
import com.smalaca.orderpreparation.command.domain.disposal.AcceptShoppingDomainCommand;
import com.smalaca.orderpreparation.command.domain.disposal.PaymentType;
import com.smalaca.orderpreparation.command.domain.productmanagement.ProductManagement;

import java.util.UUID;

public record AcceptShoppingCommand(
        UUID shoppingId, String deliveryType,
        String street, String houseNumber, String city,
        String paymentType) {
    AcceptShoppingDomainCommand asAcceptShoppingDomainCommand(ProductManagement productManagement) {
        return new AcceptShoppingDomainCommand(
                new DeliveryType(deliveryType),
                new Address(street, houseNumber, city),
                new PaymentType(paymentType),
                productManagement
        );
    }
}
