package com.smalaca.productsmanagement.command.application.assortment;

import java.util.UUID;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.productsmanagement.command.domain.assortment.Assortment;
import com.smalaca.productsmanagement.command.domain.assortment.AssortmentRepository;

import lombok.AllArgsConstructor;

@PrimaryAdapter
@AllArgsConstructor
public class AssortmentApplicationService {

    private final AssortmentRepository assortmentRepository;

    public UUID addProduct(final NewProductCommand command) {
        // translate from api to domain language, primitives -> VA, id -> aggregate [0 ... *]
        Assortment assortment = assortmentRepository.read(command.getAssortmentId());

        // invoke aggregate method [1]
        assortment.addProduct();

        // save aggregate [1 ... *] / publish events [1]
        assortmentRepository.save(assortment);
        return UUID.randomUUID();
    }

}