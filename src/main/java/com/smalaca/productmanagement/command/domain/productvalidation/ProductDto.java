package com.smalaca.productmanagement.command.domain.productvalidation;

import java.math.BigDecimal;

public record ProductDto(String name, BigDecimal price) {
}
