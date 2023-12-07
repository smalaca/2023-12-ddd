package com.smalaca.orderpreparation.command.application.shoppinglist;

import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingList;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingListFactory;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingListRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShoppingListApplicationService {

    private final ShoppingListRepository repository;

    private final ShoppingListFactory shoppingListFactory;

    @Transactional
    public UUID approve(final ApproveCartCommand command) {
        ShoppingList shoppingList = shoppingListFactory.create(command.getCustomer(), command.getProducts());

        repository.save(shoppingList);
        return null;
    }
}
