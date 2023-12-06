package com.smalaca.orderpreparation.infrastructure.shoppinglist.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingList;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingListId;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingListRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShoppingListMapRepository implements ShoppingListRepository {

    private final Map<ShoppingListId, ShoppingList> store = new HashMap<>();

    @Override
    public void save(final ShoppingList order) {
        store.put(order.getId(), order);
    }

    @Override
    public ShoppingList read(final ShoppingListId id) {
        return store.get(id);
    }

    @Override
    public ShoppingListId generateId() {
        return ShoppingListId.of(UUID.randomUUID());
    }
}
