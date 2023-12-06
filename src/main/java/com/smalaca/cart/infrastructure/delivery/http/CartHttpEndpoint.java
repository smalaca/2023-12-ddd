package com.smalaca.cart.infrastructure.delivery.http;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smalaca.productsmanagement.command.application.assortment.NewProductCommand;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController(value = "/cart")
public class CartHttpEndpoint {


    @PostMapping(value = "/add-product")
    public UUID addProduct(final NewProductCommand command) {
        return UUID.randomUUID();
    }

}