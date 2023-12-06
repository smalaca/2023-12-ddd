package com.smalaca.productmanagement.command.domain.assortment;

import com.smalaca.annotation.ddd.DomainEvent;
import com.smalaca.productmanagement.command.domain.eventpublisher.EventId;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@DomainEvent
@Getter
public class InvalidProductRecognized {
    private final EventId eventId;
    private final UUID assortmentId;
    private final String name;
    private final BigDecimal price;

    private InvalidProductRecognized(EventId eventId, UUID assortmentId, String name, BigDecimal price) {
        this.eventId = eventId;
        this.assortmentId = assortmentId;
        this.name = name;
        this.price = price;
    }

    static InvalidProductRecognized create(UUID assortmentId, String name, Price price) {
        return new InvalidProductRecognized(EventId.create(), assortmentId, name, price.value());
    }
}
