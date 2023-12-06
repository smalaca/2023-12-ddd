package com.smalaca.prepareorder.command.application.disposition;

import java.util.List;
import java.util.UUID;

public record ConfirmationOfProductsCommand(List<UUID> listOfProducts, String transportType, AddressVO addressVO, String paymentType) {
}
