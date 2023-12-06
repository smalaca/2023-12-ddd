package com.smalaca.productsmanagement.command.application.assortment;

import java.util.UUID;

import lombok.Value;

@Value(staticConstructor = "of")
public class NewProductCommand {

    private final UUID assortmentId;

}
