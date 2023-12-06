package com.smalaca.orderpreparation.infrastructure.shoppinglist.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingList;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingListRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShoppingListMapRepository implements ShoppingListRepository {

    private final Map<UUID, ShoppingList> store = new HashMap<>();

    @Override
    public void save(final ShoppingList order) {
        store.put(order.getId(), order);
    }

    @Override
    public ShoppingList read(final UUID id) {
        return store.get(id);
    }

    @Override
    public UUID generateId() {
        return UUID.randomUUID();
    }
}
