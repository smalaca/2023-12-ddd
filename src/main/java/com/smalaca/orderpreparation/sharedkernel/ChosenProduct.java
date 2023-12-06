package com.smalaca.orderpreparation.sharedkernel;

import com.smalaca.productsmanagement.command.domain.assortment.Price;
import com.smalaca.productsmanagement.command.domain.assortment.Quantity;

import lombok.Value;

@Value(staticConstructor = "of")
public class ChosenProduct {

    private final ProductId id;

    private final Price price;

    private final Quantity quantity;

}
