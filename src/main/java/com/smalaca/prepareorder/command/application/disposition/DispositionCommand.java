package com.smalaca.prepareorder.command.application.disposition;

import java.util.UUID;

public record DispositionCommand(UUID shoppingId, String transportType, String street,String city,String houseNumber, String paymentType) {
}
