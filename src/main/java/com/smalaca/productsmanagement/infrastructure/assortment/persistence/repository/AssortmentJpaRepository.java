package com.smalaca.productsmanagement.infrastructure.assortment.persistence.repository;

import java.util.UUID;

import com.smalaca.productsmanagement.command.domain.assortment.Assortment;
import com.smalaca.productsmanagement.command.domain.assortment.AssortmentRepository;

public class AssortmentJpaRepository implements AssortmentRepository {

    @Override
    public void save(final Assortment assortment) {

    }

    @Override
    public Assortment read(final UUID is) {
        return null;
    }
}
