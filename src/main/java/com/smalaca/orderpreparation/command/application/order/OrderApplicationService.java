package com.smalaca.orderpreparation.command.application.order;

import java.util.Optional;
import java.util.UUID;

import com.smalaca.eventbus.EventBus;
import com.smalaca.orderpreparation.command.domain.order.Order;
import com.smalaca.orderpreparation.command.domain.order.OrderRepository;
import com.smalaca.orderpreparation.command.domain.order.ProductsAvailabilityValidator;
import com.smalaca.orderpreparation.command.domain.order.ProductsReservationService;
import com.smalaca.orderpreparation.command.domain.producttoorder.ShoppingList;
import com.smalaca.orderpreparation.command.domain.producttoorder.ShoppingListRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderApplicationService {

    private final OrderRepository repository;

    private final ShoppingListRepository shoppingListAccessor;

    private final ProductsAvailabilityValidator productsAvailabilityValidator;

    private final ProductsReservationService productsReservationService;

    private final EventBus eventBus;

    public UUID accept(final AcceptProductsCommand command) {
        ShoppingList shoppingList = shoppingListAccessor.read(command.getShoppingListId());

        Optional<Order> order = shoppingList.acceptProducts(repository.generateId(), eventBus, productsReservationService, productsAvailabilityValidator);

        order.ifPresent(repository::save);
        return order.map(Order::getId).orElse(null);
    }
}
