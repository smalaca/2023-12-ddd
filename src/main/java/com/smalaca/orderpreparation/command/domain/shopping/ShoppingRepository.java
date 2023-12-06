package com.smalaca.orderpreparation.command.domain.shopping;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
@SecondaryPort
public interface ShoppingRepository {
    Shopping findById(UUID shoppingId);

    UUID save(Shopping shopping);
}
