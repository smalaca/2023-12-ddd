package com.smalaca.prepareorder.command.application.disposition;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public record AddressVO(String street,String city,String houseNumber) {
}
