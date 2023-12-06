package com.smalaca.orderpreparation.command.domain.disposal;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class Address {
    private final String street;
    private final String houseNumber;
    private final String city;

    public Address(String street, String houseNumber, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
    }
}
