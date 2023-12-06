package com.smalaca.productmanagement.command.domain.assortment;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
@SecondaryPort
public interface AssortmentRepository {
    Assortment findById(UUID uuid);

    void save(Assortment assortment);
}
