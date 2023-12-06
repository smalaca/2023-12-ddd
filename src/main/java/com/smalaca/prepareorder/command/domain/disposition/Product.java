package com.smalaca.prepareorder.command.domain.disposition;

import com.smalaca.annotation.ddd.DomainEntity;
import com.smalaca.annotation.ddd.ValueObject;

import java.math.BigDecimal;
import java.util.UUID;

@ValueObject
public record Product(UUID id, BigDecimal price) {

}
