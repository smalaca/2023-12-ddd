package com.smalaca.orderpreparation.infrastructure.rest.shopping;

import com.smalaca.orderpreparation.command.application.shopping.ConfirmChoiceCommand;
import com.smalaca.orderpreparation.command.application.shopping.ShoppingApplicationService;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ShoppingRestController {
    private final ShoppingApplicationService shoppingApplicationService;

    public ShoppingRestController(ShoppingApplicationService shoppingApplicationService) {
        this.shoppingApplicationService = shoppingApplicationService;
    }

    public UUID accept(UUID shoppingId) {
        return shoppingApplicationService.accept(shoppingId);
    }

    public UUID confirm(ConfirmChoiceCommand command) {
        return shoppingApplicationService.confirm(command);
    }
}
