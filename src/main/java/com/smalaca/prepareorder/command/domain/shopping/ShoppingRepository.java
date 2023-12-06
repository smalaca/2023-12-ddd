package com.smalaca.prepareorder.command.domain.shopping;


import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
@SecondaryPort
public interface ShoppingRepository {

    public void save(Shopping disposition);

    public Shopping findById(UUID uuid);
}
