package com.smalaca.orderpreparation.infrastructure.producttoorder;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smalaca.orderpreparation.command.application.producttoorder.ApproveCartCommand;
import com.smalaca.orderpreparation.command.application.producttoorder.ProductToOrderApplicationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController(value = "/order")
public class ProductToOrderHttpEndpoint {

    private final ProductToOrderApplicationService orderApplicationService;

    @PostMapping(value = "/approve")
    public UUID approve(final ApproveCartCommand command) {
        return orderApplicationService.approve(command);
    }


}