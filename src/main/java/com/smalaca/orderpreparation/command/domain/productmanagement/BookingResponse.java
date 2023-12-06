package com.smalaca.orderpreparation.command.domain.productmanagement;

import java.util.Map;
import java.util.UUID;

public record BookingResponse(boolean bookedAll, Map<UUID, Integer> missing) {
}
