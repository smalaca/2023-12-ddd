package com.smalaca.orderpreparation.command.domain.shopping;

import com.smalaca.annotation.ddd.DomainEvent;
import com.smalaca.orderpreparation.command.domain.eventpublisher.EventId;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@DomainEvent
@Getter
public class ProductsNotFound {
    private final EventId eventId;
    private final UUID shoppingId;
    private final ShoppingNumber shoppingNumber;
    private final Map<UUID, Integer> missingProducts;

    private ProductsNotFound(EventId eventId, UUID shoppingId, ShoppingNumber shoppingNumber, Map<UUID, Integer> missingProducts) {
        this.eventId = eventId;
        this.shoppingId = shoppingId;
        this.shoppingNumber = shoppingNumber;
        this.missingProducts = missingProducts;
    }

    static ProductsNotFound create(UUID shoppingId, ShoppingNumber shoppingNumber, Map<UUID, Integer> missingProducts) {
        return new ProductsNotFound(EventId.create(), shoppingId, shoppingNumber, missingProducts);
    }
}
