package com.smalaca.orderpreparation.command.domain.productmanagement;

import com.smalaca.annotation.architecture.SecondaryPort;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@SecondaryPort
public interface ProductManagement {
    BookingResponse book(Map<UUID, Integer> productsToBook);

    Map<UUID, BigDecimal> priceFor(Set<UUID> productIds);
}
