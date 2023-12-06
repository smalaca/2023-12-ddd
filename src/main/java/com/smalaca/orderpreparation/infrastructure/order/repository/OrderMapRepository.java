package com.smalaca.orderpreparation.infrastructure.order.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.smalaca.orderpreparation.command.domain.order.Order;
import com.smalaca.orderpreparation.command.domain.order.OrderRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderMapRepository implements OrderRepository {

    private final Map<UUID, Order> store = new HashMap<>();

    @Override
    public void save(final Order order) {
        store.put(order.getId(), order);
    }

    @Override
    public UUID generateId() {
        return UUID.randomUUID();
    }
}
