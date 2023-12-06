package com.smalaca.orderpreparation.command.application.order;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import com.smalaca.eventbus.EventBus;
import com.smalaca.orderpreparation.command.domain.order.Order;
import com.smalaca.orderpreparation.command.domain.order.OrderId;
import com.smalaca.orderpreparation.command.domain.order.OrderRepository;
import com.smalaca.orderpreparation.command.domain.order.ProductsAvailabilityValidator;
import com.smalaca.orderpreparation.command.domain.order.ProductsReservationService;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingList;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingListRepository;
import com.smalaca.sharedkernel.CustomerId;

import lombok.AllArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
public class OrderApplicationService {

    private final OrderRepository repository;

    private final ShoppingListRepository shoppingListAccessor;

    private final ProductsAvailabilityValidator productsAvailabilityValidator;

    private final ProductsReservationService productsReservationService;

    private final Function<CustomerId, String> randomNumberGenerator = customerId -> customerId.getId().toString() + UUID.randomUUID();

    private final EventBus eventBus;

    @Transactional
    public OrderId accept(final AcceptProductsCommand command) {
        ShoppingList shoppingList = shoppingListAccessor.read(command.getShoppingListId());

        Optional<Order> order = shoppingList.accept(repository.generateId(), randomNumberGenerator,
                                                    command.getCustomer(), command.getParams(),
                                                    eventBus, productsReservationService, productsAvailabilityValidator
        );

        order.ifPresent(repository::save);
        return order.map(Order::getId).orElse(null); // todo or throw ex
    }
}
