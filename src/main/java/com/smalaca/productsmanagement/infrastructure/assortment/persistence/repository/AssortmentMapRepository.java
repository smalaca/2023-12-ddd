package com.smalaca.productsmanagement.infrastructure.assortment.persistence.repository;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.smalaca.productsmanagement.command.domain.assortment.Assortment;
import com.smalaca.productsmanagement.command.domain.assortment.AssortmentRepository;

@AllArgsConstructor
public class AssortmentMapRepository implements AssortmentRepository {

    private final Map<UUID, Assortment> store = new HashMap<>();

    @Override
    public void save(final Assortment assortment) {
        store.put(assortment.getId(), assortment);
    }

    @Override
    public Assortment read(final UUID id) {
        return store.get(id);
    }

}
