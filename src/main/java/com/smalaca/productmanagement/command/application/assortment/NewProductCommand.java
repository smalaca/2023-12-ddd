package com.smalaca.productmanagement.command.application.assortment;

import java.math.BigDecimal;
import java.util.UUID;

public record NewProductCommand(UUID assortmentId, int amount, BigDecimal price) {
}
