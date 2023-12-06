package com.smalaca.orderpreparation.command.application.order;

import java.util.UUID;

import com.smalaca.eventbus.EventBus;
import com.smalaca.orderpreparation.command.domain.order.Order;
import com.smalaca.orderpreparation.command.domain.order.OrderRepository;
import com.smalaca.orderpreparation.command.domain.order.ProductAcceptedEvent;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderApplicationService {

    private final OrderRepository orderRepository;

    private final ProductToOrderAccessor productToOrderAccessor;

    private final EventBus eventBus;

    public UUID accept(final AcceptProductsCommand command) {
        Order order = Order.of(orderRepository.generateId());
        Object products = productToOrderAccessor.read(command.getProductsToOrderId());

        order.acceptProducts(products);

        orderRepository.save(order);
        eventBus.fire(ProductAcceptedEvent.of(products));
        return order.getId();
    }
}
