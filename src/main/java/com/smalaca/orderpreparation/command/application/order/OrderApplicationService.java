package com.smalaca.orderpreparation.command.application.order;

import java.util.UUID;

import com.smalaca.eventbus.EventBus;
import com.smalaca.orderpreparation.command.domain.order.Order;
import com.smalaca.orderpreparation.command.domain.order.OrderRepository;
import com.smalaca.orderpreparation.command.domain.order.ProductsAvailabilityValidator;
import com.smalaca.orderpreparation.command.domain.order.ProductsReservationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderApplicationService {

    private final OrderRepository orderRepository;

    private final ProductToOrderAccessor productToOrderAccessor;

    private final ProductsAvailabilityValidator productsAvailabilityValidator;

    private final ProductsReservationService productsReservationService;

    private final EventBus eventBus;

    public UUID accept(final AcceptProductsCommand command) {
        Order order = Order.of(orderRepository.generateId());
        Object products = productToOrderAccessor.read(command.getProductsToOrderId());

        order.acceptProducts(eventBus, productsReservationService, productsAvailabilityValidator, products);

        orderRepository.save(order);
        return order.getId();
    }
}
