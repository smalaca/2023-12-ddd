package com.smalaca.orderpreparation.sharedkernel;

import com.smalaca.productsmanagement.command.domain.assortment.Price;
import com.smalaca.productsmanagement.command.domain.assortment.Quantity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class ChosenProduct {

    @Valid
    @NotNull
    private final ProductId id;

    @Valid
    @NotNull
    private final Price price;

    @Valid
    @NotNull
    private final Quantity quantity;

}
