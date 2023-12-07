package com.smalaca.cart.infrastructure.delivery.event;

import com.smalaca.orderpreparation.command.domain.order.PurchaseAcceptedEvent;

public class PurchaseAcceptedEventListener /*todo some interface to listen on event bus*/ {

    public void handle(final PurchaseAcceptedEvent event) {
        // todo usuniecie z koszyka
    }

}
