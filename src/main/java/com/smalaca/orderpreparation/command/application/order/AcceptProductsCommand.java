package com.smalaca.orderpreparation.command.application.order;

import java.util.UUID;

import com.smalaca.orderpreparation.command.domain.order.DeliveryInfo;
import com.smalaca.orderpreparation.command.domain.order.PaymentType;
import com.smalaca.sharedcernel.CustomerId;

import lombok.Value;

@Value(staticConstructor = "of")
public class AcceptProductsCommand {

    private final CustomerId customer;

    private final UUID shoppingListId;

    private final AcceptParams params;

    @Value(staticConstructor = "of")
    public static class AcceptParams {

        private final DeliveryInfo deliveryInfo;

        private final PaymentType paymentType;

    }
}
