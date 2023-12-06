package com.smalaca.orderpreparation.command.application.shoppinglist;

import java.util.UUID;
import java.util.function.Function;

import org.springframework.transaction.annotation.Transactional;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.eventbus.EventBus;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingList;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingListNumber;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingListRepository;
import com.smalaca.sharedkernel.CustomerId;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShoppingListApplicationService {

    private final ShoppingListRepository repository;

    private final EventBus eventBus;

    @Factory
    private final Function<CustomerId, ShoppingListNumber> randomNumberGenerator =
        customerId -> ShoppingListNumber.of(String.join("-", customerId.getId().toString(), UUID.randomUUID().toString()));

    @Transactional
    public UUID approve(final ApproveCartCommand command) {
        ShoppingList shoppingList = ShoppingList.of(repository.generateId(), randomNumberGenerator, command.getCustomer(), command.getProducts(), eventBus);

        repository.save(shoppingList);
        return null;
    }
}
