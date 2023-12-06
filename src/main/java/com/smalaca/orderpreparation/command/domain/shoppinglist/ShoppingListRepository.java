package com.smalaca.orderpreparation.command.domain.shoppinglist;

public interface ShoppingListRepository {

    void save(ShoppingList order);

    ShoppingList read(ShoppingListId uuid);

    ShoppingListId generateId();

}
