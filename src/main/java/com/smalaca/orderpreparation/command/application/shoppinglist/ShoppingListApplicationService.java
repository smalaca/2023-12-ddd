package com.smalaca.orderpreparation.command.application.shoppinglist;

import java.util.UUID;
import java.util.function.Function;

import com.smalaca.eventbus.EventBus;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingList;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingListRepository;
import com.smalaca.sharedkernel.CustomerId;

import lombok.AllArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
public class ShoppingListApplicationService {

    private final ShoppingListRepository repository;

    private final EventBus eventBus;

    private final Function<CustomerId, String> randomNumberGenerator = customerId -> customerId.getId().toString() + UUID.randomUUID();

    @Transactional
    public UUID approve(final ApproveCartCommand command) {
        ShoppingList shoppingList = ShoppingList.of(repository.generateId(), randomNumberGenerator, command.getCustomer(), command.getProducts(), eventBus);

        repository.save(shoppingList);
        return null;
    }
}
