package com.smalaca.orderpreparation.command.domain.order;

import java.util.UUID;

public interface OrderRepository {
    void save(Order order);
    UUID generateId();
}
