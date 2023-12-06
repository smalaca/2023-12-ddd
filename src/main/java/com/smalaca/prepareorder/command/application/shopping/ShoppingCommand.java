package com.smalaca.prepareorder.command.application.shopping;

import com.smalaca.prepareorder.command.application.disposition.AddressVO;

import java.util.UUID;

public record ShoppingCommand(UUID buyerId, String transportType, AddressVO addressVO, String paymentType) {
}
