package com.smalaca.orderpreparation.command.domain.eventpublisher;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.orderpreparation.command.domain.shopping.ProductsNotFound;
import com.smalaca.orderpreparation.command.domain.shopping.ShoppingAccepted;

@SecondaryPort
public interface EventPublisher {
    void publish(ShoppingAccepted shoppingAccepted);

    void publish(ProductsNotFound productsNotFound);
}
