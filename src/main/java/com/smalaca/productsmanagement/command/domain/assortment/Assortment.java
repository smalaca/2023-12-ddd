package com.smalaca.productsmanagement.command.domain.assortment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.productsmanagement.command.application.assortment.NewProductCommand;
import com.smalaca.validation.ValidatorExecutor;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AggregateRoot
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Assortment {

    @NotNull
    private UUID id;

    @NotNull
    private final List<Product> products;

    public static Assortment of(final UUID id) {
        return ValidatorExecutor.validateAndReturn(new Assortment(id, new ArrayList<>()));
    }

    @PrimaryPort
    public void addProduct(final NewProductCommand.NewProductParams params) {
        this.products.add(Product.of(UUID.randomUUID(), params.getName(), params.getDescription(), params.getPrice(), params.getQuantity()));
    }

}