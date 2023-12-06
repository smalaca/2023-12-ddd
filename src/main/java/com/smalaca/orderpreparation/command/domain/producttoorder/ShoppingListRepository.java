package com.smalaca.orderpreparation.command.domain.producttoorder;

import java.util.UUID;

public interface ShoppingListRepository {

    void save(ShoppingList order);

    ShoppingList read(UUID uuid);

    UUID generateId();

}
