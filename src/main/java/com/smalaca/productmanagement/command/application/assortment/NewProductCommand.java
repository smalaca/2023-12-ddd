package com.smalaca.productmanagement.command.application.assortment;

import com.smalaca.productmanagement.command.domain.assortment.Amount;
import com.smalaca.productmanagement.command.domain.assortment.NewProductDomainCommand;
import com.smalaca.productmanagement.command.domain.assortment.Price;
import com.smalaca.productmanagement.command.domain.eventpublisher.EventPublisher;
import com.smalaca.productmanagement.command.domain.productvalidation.ProductValidation;

import java.math.BigDecimal;
import java.util.UUID;

public record NewProductCommand(UUID assortmentId, int amount, BigDecimal price, String name, String description) {
    NewProductDomainCommand asNewProductDomainCommand(ProductValidation productValidation, EventPublisher eventPublisher) {
        return new NewProductDomainCommand(new Amount(amount), new Price(price), name, description, productValidation, eventPublisher);
    }
}
