package com.smalaca.productmanagement.command.domain.eventpublisher;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.productmanagement.command.domain.assortment.InvalidProductRecognized;
import com.smalaca.productmanagement.command.domain.assortment.ProductAdded;

@SecondaryPort
public interface EventPublisher {
    void publish(ProductAdded productAdded);

    void publish(InvalidProductRecognized invalidProductRecognized);
}
