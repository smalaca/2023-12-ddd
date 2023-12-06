package com.smalaca.orderpreparation.command.domain.order;

import java.util.UUID;

import com.smalaca.annotation.ddd.DomainRepository;

@DomainRepository
public interface OrderRepository {

    void save(Order order);

    UUID generateId();

}
