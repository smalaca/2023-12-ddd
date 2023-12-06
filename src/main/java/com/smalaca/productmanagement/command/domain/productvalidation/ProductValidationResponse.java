package com.smalaca.productmanagement.command.domain.productvalidation;

public record ProductValidationResponse(boolean isValid, String reason) {
}
