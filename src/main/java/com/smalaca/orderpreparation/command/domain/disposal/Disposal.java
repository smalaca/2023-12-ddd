package com.smalaca.orderpreparation.command.domain.disposal;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.orderpreparation.command.domain.product.Product;

import java.util.List;
import java.util.UUID;

@AggregateRoot
public class Disposal {
    private final UUID shoppingId;
    private final List<Product> products;
    private final DeliveryType deliveryType;
    private final Address address;
    private final PaymentType paymentType;

    public Disposal(UUID shoppingId, List<Product> products, AcceptShoppingDomainCommand command) {
        this.shoppingId = shoppingId;
        this.products = products;
        this.deliveryType = command.deliveryType();
        this.address = command.address();
        this.paymentType = command.paymentType();
    }
}
