package com.smalaca.prepareorder.command.application.disposition;

import java.util.UUID;

public record DispositionCommand(UUID shoppingId, String transportType, AddressVO addressVO, String paymentType) {
}
