package com.smalaca.orderpreparation.infrastructure.order.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.smalaca.orderpreparation.command.domain.order.Order;
import com.smalaca.orderpreparation.command.domain.order.OrderId;
import com.smalaca.orderpreparation.command.domain.order.OrderRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderMapRepository implements OrderRepository {

    private final Map<OrderId, Order> store = new HashMap<>();

    @Override
    public void save(final Order order) {
        store.put(order.getId(), order);
    }

    @Override
    public OrderId generateId() {
        return OrderId.of(UUID.randomUUID());
    }
}
