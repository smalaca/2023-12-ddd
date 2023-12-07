package com.smalaca.prepareorder.command.domain.product;

import com.smalaca.annotation.ddd.ValueObject;

import java.math.BigDecimal;
import java.util.UUID;

@ValueObject
public record ProductVO(UUID id, BigDecimal price) {

}
