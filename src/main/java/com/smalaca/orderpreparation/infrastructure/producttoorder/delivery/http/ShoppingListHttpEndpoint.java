package com.smalaca.orderpreparation.infrastructure.producttoorder.delivery.http;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smalaca.orderpreparation.command.application.producttoorder.ApproveCartCommand;
import com.smalaca.orderpreparation.command.application.producttoorder.ProductToOrderApplicationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController(value = "/shopping-list")
public class ShoppingListHttpEndpoint {

    private final ProductToOrderApplicationService service;

    @PostMapping(value = "/approve")
    public UUID approve(final ApproveCartCommand command) {
        return service.approve(command);
    }

}