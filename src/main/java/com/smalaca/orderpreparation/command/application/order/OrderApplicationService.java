package com.smalaca.orderpreparation.command.application.order;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.transaction.annotation.Transactional;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.command.domain.order.Order;
import com.smalaca.orderpreparation.command.domain.order.OrderId;
import com.smalaca.orderpreparation.command.domain.order.OrderNumber;
import com.smalaca.orderpreparation.command.domain.order.OrderRepository;
import com.smalaca.orderpreparation.command.domain.products.ProductsAvailabilityValidator;
import com.smalaca.orderpreparation.command.domain.products.ProductsReservationService;
import com.smalaca.orderpreparation.command.domain.shoppinglist.AcceptParamsWrapper;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingList;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingListRepository;
import com.smalaca.sharedkernel.CustomerId;
import com.smalaca.sharedkernel.domain.eventbus.EventBus;
import com.smalaca.sharedkernel.domain.time.TimeProvider;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderApplicationService {

    private final OrderRepository repository;

    private final ShoppingListRepository shoppingListAccessor;

    private final ProductsAvailabilityValidator productsAvailabilityValidator;

    private final ProductsReservationService productsReservationService;

    private final TimeProvider timeProvider;

    @Factory
    private final Function<CustomerId, OrderNumber> randomNumberGenerator =
        customerId -> OrderNumber.of(String.join("-", customerId.getId().toString(), UUID.randomUUID().toString()));

    private final EventBus eventBus;

    @Transactional
    public OrderId accept(final AcceptProductsCommand command) {
        ShoppingList shoppingList = shoppingListAccessor.read(command.getShoppingListId());
        AcceptParamsWrapper acceptParamsWrapper = new AcceptParamsWrapper(
            repository.generateId(), command.getParams(), command.getCustomer(),
            timeProvider, eventBus, randomNumberGenerator, productsReservationService, productsAvailabilityValidator
        );

        Optional<Order> order = shoppingList.accept(acceptParamsWrapper);

        order.ifPresent(repository::save);
        return order.map(Order::getId).orElse(null); // todo or throw ex
    }
}
