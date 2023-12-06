package com.smalaca.orderpreparation.command.domain.order;

import com.smalaca.annotation.ddd.DomainRepository;

@DomainRepository
public interface OrderRepository {

    void save(Order order);

    OrderId generateId();

}
