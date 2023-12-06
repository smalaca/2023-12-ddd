package com.smalaca.prepareorder.command.domain.shopping;

import java.math.BigDecimal;
import java.util.UUID;

public record Product(UUID id, BigDecimal price) {

}
