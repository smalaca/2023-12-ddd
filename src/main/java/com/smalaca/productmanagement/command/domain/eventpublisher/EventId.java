package com.smalaca.productmanagement.command.domain.eventpublisher;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class EventId {
    private final UUID eventId;
    private final UUID traceId;
    private final UUID correlationId;
    private final LocalDateTime creationDateTime;

    private EventId(UUID eventId, UUID traceId, UUID correlationId, LocalDateTime creationDateTime) {
        this.eventId = eventId;
        this.traceId = traceId;
        this.correlationId = correlationId;
        this.creationDateTime = creationDateTime;
    }

    public static EventId create() {
        return new EventId(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), LocalDateTime.now());
    }
}
