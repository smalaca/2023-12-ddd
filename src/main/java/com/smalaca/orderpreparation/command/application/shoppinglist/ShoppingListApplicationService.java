package com.smalaca.orderpreparation.command.application.shoppinglist;

import java.util.UUID;

import com.smalaca.eventbus.EventBus;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingList;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingListRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShoppingListApplicationService {

    private final ShoppingListRepository repository;

    private final EventBus eventBus;

    public UUID approve(final ApproveCartCommand command) {
        ShoppingList shoppingList = ShoppingList.of(repository.generateId(), command.getCustomer(), command.getProducts(), eventBus);

        repository.save(shoppingList);
        return null;
    }
}
