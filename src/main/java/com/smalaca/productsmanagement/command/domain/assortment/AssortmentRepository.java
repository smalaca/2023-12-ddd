package com.smalaca.productsmanagement.command.domain.assortment;

import java.util.UUID;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

@SecondaryPort
@DomainRepository
public interface AssortmentRepository {
    void save(Assortment assortment);
    Assortment read(UUID is);
}
