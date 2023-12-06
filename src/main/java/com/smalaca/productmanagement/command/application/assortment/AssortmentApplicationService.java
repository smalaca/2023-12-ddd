package com.smalaca.productmanagement.command.application.assortment;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.productmanagement.command.domain.assortment.Assortment;
import com.smalaca.productmanagement.command.domain.assortment.AssortmentRepository;
import com.smalaca.productmanagement.command.domain.eventpublisher.EventPublisher;
import com.smalaca.productmanagement.command.domain.productvalidation.ProductValidation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@PrimaryAdapter
public class AssortmentApplicationService {
    private final AssortmentRepository assortmentRepository;
    private final ProductValidation productValidation;
    private final EventPublisher eventPublisher;

    public AssortmentApplicationService(
            AssortmentRepository assortmentRepository, ProductValidation productValidation, EventPublisher eventPublisher) {
        this.assortmentRepository = assortmentRepository;
        this.productValidation = productValidation;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public UUID addProduct(NewProductCommand command) {
        // tłumaczenie ze świata zewnętrznego na ubiquitous language [0 ... *]
        // typy proste -> value object
        // id -> aggregate
        Assortment assortment = assortmentRepository.findById(command.assortmentId());

        // wywołanie metody z domeny [1]
        assortment.addProduct(command.asNewProductDomainCommand(productValidation, eventPublisher));

        // zapis agregatów [1...*] LUB/I opublikowanie zdarzeń [1]
        return assortmentRepository.save(assortment);
    }
}
