package com.smalaca.prepareorder.command.domain.shopping;

import com.smalaca.annotation.ddd.DomainEntity;

import java.math.BigDecimal;
import java.util.UUID;
@DomainEntity
public record Product(UUID id, BigDecimal price) {

}
