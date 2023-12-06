package com.smalaca.prepareorder.command.domain.payment;


import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record PaymentEvent(UUID eventID,List<Item> items) {
    public record Item(UUID productID, Integer amount, BigDecimal price){}
}


