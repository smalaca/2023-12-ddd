package com.smalaca.orderpreparation.command.domain.shoppinglist;

import java.util.UUID;

public interface ShoppingListRepository {

    void save(ShoppingList order);

    ShoppingList read(UUID uuid);

    UUID generateId();

}
