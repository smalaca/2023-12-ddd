package com.smalaca.orderpreparation.command.domain.shopping;

import com.smalaca.annotation.ddd.DomainEvent;
import com.smalaca.orderpreparation.command.domain.eventpublisher.EventId;
import lombok.Getter;

import java.util.UUID;

@DomainEvent
@Getter
public class ShoppingAccepted {
    private final EventId eventId;
    private final UUID shoppingId;
    private final ShoppingNumber shoppingNumber;

    private ShoppingAccepted(EventId eventId, UUID shoppingId, ShoppingNumber shoppingNumber) {
        this.eventId = eventId;
        this.shoppingId = shoppingId;
        this.shoppingNumber = shoppingNumber;
    }

    static ShoppingAccepted create(UUID shoppingId, ShoppingNumber shoppingNumber) {
        return new ShoppingAccepted(EventId.create(), shoppingId, shoppingNumber);
    }
}
