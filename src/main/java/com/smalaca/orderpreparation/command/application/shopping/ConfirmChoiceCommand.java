package com.smalaca.orderpreparation.command.application.shopping;

import java.util.Map;
import java.util.UUID;

public record ConfirmChoiceCommand(UUID buyerId, Map<UUID, Integer> products) {

}
