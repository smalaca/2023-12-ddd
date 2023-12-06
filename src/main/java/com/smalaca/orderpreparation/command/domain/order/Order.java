package com.smalaca.orderpreparation.command.domain.order;

import java.util.UUID;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.validation.ValidatorExecutor;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AggregateRoot
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {

    @NotNull
    private UUID id;

    public static Order of(final UUID id) {
        return ValidatorExecutor.validateAndReturn(new Order(id));
    }
}
