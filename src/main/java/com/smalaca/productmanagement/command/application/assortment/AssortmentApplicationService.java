package com.smalaca.productmanagement.command.application.assortment;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.productmanagement.command.domain.assortment.Amount;
import com.smalaca.productmanagement.command.domain.assortment.Assortment;
import com.smalaca.productmanagement.command.domain.assortment.AssortmentRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@PrimaryAdapter
public class AssortmentApplicationService {
    private final AssortmentRepository assortmentRepository;

    public AssortmentApplicationService(AssortmentRepository assortmentRepository) {
        this.assortmentRepository = assortmentRepository;
    }

    @Transactional
    public UUID addProduct(NewProductCommand command) {
        // tłumaczenie ze świata zewnętrznego na ubiquitous language [0 ... *]
        // typy proste -> value object
        // id -> aggregate
        Assortment assortment = assortmentRepository.findById(command.assortmentId());
        Amount amount = new Amount(command.amount());

        // wywołanie metody z domeny [1]
        assortment.addProduct(amount);

        // zapis agregatów [1...*] LUB/I opublikowanie zdarzeń [1]
        return assortmentRepository.save(assortment);
    }
}
