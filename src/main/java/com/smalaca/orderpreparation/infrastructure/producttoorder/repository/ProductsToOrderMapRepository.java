package com.smalaca.orderpreparation.infrastructure.producttoorder.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.smalaca.orderpreparation.command.domain.order.Order;
import com.smalaca.orderpreparation.command.domain.order.OrderRepository;
import com.smalaca.orderpreparation.command.domain.producttoorder.ProductsToOrder;
import com.smalaca.orderpreparation.command.domain.producttoorder.ProductsToOrderRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductsToOrderMapRepository implements ProductsToOrderRepository {

    private final Map<UUID, ProductsToOrder> store = new HashMap<>();

    @Override
    public void save(final ProductsToOrder order) {
        store.put(order.getId(), order);
    }

    @Override
    public ProductsToOrder read(final UUID id) {
        return store.get(id);
    }
}
