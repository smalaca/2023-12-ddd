package com.smalaca.productsmanagement.command.domain.assortment;

import com.smalaca.annotation.ddd.DomainEntity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import java.util.UUID;

@DomainEntity
@AllArgsConstructor(staticName = "of")
class Product {

    private final UUID id;

    @NotBlank
    private final String name;

    @NotNull
    private final String description;

    @NotNull
    private final Price price;

    @Min(1)
    private final Quantity quantity;

}
