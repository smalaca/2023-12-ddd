package com.smalaca.cart.infrastructure.delivery.event;

import com.smalaca.orderpreparation.command.domain.order.ProductsNotFoundEvent;

public class ProductsNotFoundEventHandler /*todo some interface to listen on event bus*/ {

    public void handle(final ProductsNotFoundEvent event) {
        // todo usuniecie z koszyka
    }
}
