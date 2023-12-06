package com.smalaca.sharedkernel.domain.eventbus;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EventId {

    private final UUID id;
    private final UUID traceId;
    private final UUID correlationId;

    public static EventId of() {
        return new EventId(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());
    }

}
