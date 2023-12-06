package com.smalaca.productsmanagement.infrastructure.assortment.persistence.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.smalaca.productsmanagement.command.domain.assortment.Assortment;
import com.smalaca.productsmanagement.command.domain.assortment.AssortmentRepository;

public interface AssortmentJpaRepository extends CrudRepository<Assortment, UUID>, AssortmentRepository {

    default Assortment read(UUID id) {
        return findById(id).orElseThrow();
    }

}
