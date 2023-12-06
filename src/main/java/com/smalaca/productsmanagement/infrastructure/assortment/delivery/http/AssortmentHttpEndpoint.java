package com.smalaca.productsmanagement.infrastructure.assortment.delivery.http;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smalaca.productsmanagement.command.application.assortment.AssortmentApplicationService;
import com.smalaca.productsmanagement.command.application.assortment.NewProductCommand;
import com.smalaca.productsmanagement.query.application.assortment.AssortmentDataModel;
import com.smalaca.productsmanagement.query.application.assortment.AssortmentQueryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController(value = "/assortment")
public class AssortmentHttpEndpoint {

    private final AssortmentApplicationService assortmentApplicationService;

    private final AssortmentQueryService assortmentQueryService;

    @PostMapping(value = "/products")
    public UUID addProduct(final NewProductCommand command) {
        return assortmentApplicationService.addProduct(command);
    }

    @GetMapping
    public AssortmentDataModel displayAssortment(final UUID assortmentId) {
        return assortmentQueryService.displayAssortment(assortmentId);
    }

}