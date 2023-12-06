package com.smalaca.prepareorder.command.domain.disposition;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.prepareorder.command.application.disposition.AddressVO;

import java.util.List;
import java.util.UUID;

@AggregateRoot
public class Disposition {

    private UUID ID;
    @PrimaryPort
    public UUID  confirmProducts(List<UUID> listOfProducts, String transportType, AddressVO addressVO, String paymentType){return null;}

    public UUID getID() {
        return ID;
    }
}
