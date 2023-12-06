package com.smalaca.productmanagement.command.domain.assortment;

import com.smalaca.annotation.ddd.DomainEntity;
import com.smalaca.productmanagement.command.domain.eventpublisher.EventId;
import lombok.Getter;

import java.util.UUID;

@DomainEntity
@Getter
public class ProductAdded {
    private final EventId eventId;
    private final UUID assortmentId;

    private ProductAdded(EventId eventId, UUID assortmentId) {
        this.eventId = eventId;
        this.assortmentId = assortmentId;
    }

    static ProductAdded create(UUID assortmentId) {
        return new ProductAdded(EventId.create(), assortmentId);
    }
}
