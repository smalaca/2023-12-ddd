package com.smalaca.orderpreparation.command.application.producttoorder;

import java.util.UUID;

import com.smalaca.eventbus.EventBus;
import com.smalaca.orderpreparation.command.domain.producttoorder.ShoppingList;
import com.smalaca.orderpreparation.command.domain.producttoorder.ShoppingListRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductToOrderApplicationService {

    private final ShoppingListRepository repository;

    private final EventBus eventBus;

    public UUID approve(final ApproveCartCommand command) {
        ShoppingList shoppingList = ShoppingList.of(repository.generateId(), command.getProducts(), eventBus);

        repository.save(shoppingList);
        return null;
    }
}
