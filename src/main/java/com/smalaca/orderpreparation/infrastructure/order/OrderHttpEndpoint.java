package com.smalaca.orderpreparation.infrastructure.order;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smalaca.orderpreparation.command.application.order.AcceptProductsCommand;
import com.smalaca.orderpreparation.command.application.order.OrderApplicationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController(value = "/order")
public class OrderHttpEndpoint {

    private final OrderApplicationService orderApplicationService;

    @PostMapping(value = "/products")
    public UUID accept(final AcceptProductsCommand command) {
        return orderApplicationService.accept(command);
    }


}