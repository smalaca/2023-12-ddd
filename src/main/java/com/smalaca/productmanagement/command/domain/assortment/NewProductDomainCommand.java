package com.smalaca.productmanagement.command.domain.assortment;

import com.smalaca.productmanagement.command.domain.eventpublisher.EventPublisher;
import com.smalaca.productmanagement.command.domain.productvalidation.ProductValidation;

public record NewProductDomainCommand(
        Amount amount, Price price, String name, String description,
        ProductValidation productValidation, EventPublisher eventPublisher) {
}
