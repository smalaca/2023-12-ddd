package com.smalaca.orderpreparation.command.application.order;

import java.util.UUID;

import com.smalaca.orderpreparation.command.domain.order.Address;
import com.smalaca.orderpreparation.command.domain.order.DeliveryType;
import com.smalaca.orderpreparation.command.domain.order.PaymentType;

import lombok.Value;

@Value(staticConstructor = "of")
public class AcceptProductsCommand {

    private final UUID customer;

    private final UUID shoppingListId;

    private final AcceptParams params;

    @Value(staticConstructor = "of")
    public class AcceptParams {

        private final Address address;

        private final DeliveryType deliveryType;

        private final PaymentType paymentType;

    }
}
