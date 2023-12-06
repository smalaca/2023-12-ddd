package com.smalaca.productmanagement.infrastructure.adapter.secondary.repository.assortment;

import com.smalaca.productmanagement.command.domain.assortment.Assortment;
import com.smalaca.productmanagement.command.domain.assortment.AssortmentRepository;

import java.util.UUID;

public class SpringDataAssortmentRepository implements AssortmentRepository {
    @Override
    public Assortment findById(UUID uuid) {
        return null;
    }

    @Override
    public void save(Assortment assortment) {

    }
}
