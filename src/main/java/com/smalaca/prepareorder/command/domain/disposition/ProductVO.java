package com.smalaca.prepareorder.command.domain.disposition;

import com.smalaca.annotation.ddd.ValueObject;

import java.math.BigDecimal;
import java.util.UUID;

@ValueObject
public record ProductVO(UUID id, BigDecimal price) {

}
