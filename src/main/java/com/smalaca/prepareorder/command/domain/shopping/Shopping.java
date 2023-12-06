package com.smalaca.prepareorder.command.domain.shopping;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.prepareorder.command.application.disposition.AddressVO;
import com.smalaca.prepareorder.command.domain.disposition.Disposition;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@AggregateRoot
public class Shopping {

    private UUID ID;
    Map<UUID,Integer> listOfProductsWithAmount;

    @PrimaryPort
    public Disposition confirmProducts(String transportType, AddressVO addressVO, String paymentType){return null;}

    public UUID getID() {
        return ID;
    }
}
