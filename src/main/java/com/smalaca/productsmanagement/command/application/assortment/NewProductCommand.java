package com.smalaca.productsmanagement.command.application.assortment;

import java.util.UUID;

import com.smalaca.productsmanagement.command.domain.assortment.Price;
import com.smalaca.productsmanagement.command.domain.assortment.Quantity;

import lombok.Value;

@Value(staticConstructor = "of")
public class NewProductCommand {

    private final UUID assortmentId;

    private final NewProductParams params;

    @Value(staticConstructor = "of")
    public static class NewProductParams {

        private final Price price;

        private final Quantity quantity;

        private final String name;

        private final String description;

    }

}
