package com.smalaca.prepareorder.command.domain.disposition;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.prepareorder.command.application.disposition.AddressVO;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@AggregateRoot
public class Disposition {

    private UUID ID;
    private Map<ProductVO,Integer> listOfProductsWithAmount;
    private String transportType;
    private AddressVO addressVO;
    private String paymentType;
    public UUID getID() {
        return ID;
    }
}
