package com.smalaca.orderpreparation.command.domain.shopping;

import java.util.Map;
import java.util.UUID;

class MissingProductsException extends RuntimeException {
    private final Map<UUID, Integer> missingProducts;

    MissingProductsException(Map<UUID, Integer> missingProducts) {
        this.missingProducts = missingProducts;
    }
}
