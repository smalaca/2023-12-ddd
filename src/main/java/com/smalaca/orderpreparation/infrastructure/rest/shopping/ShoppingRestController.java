package com.smalaca.orderpreparation.infrastructure.rest.shopping;

import com.smalaca.orderpreparation.command.application.shopping.AcceptShoppingCommand;
import com.smalaca.orderpreparation.command.application.shopping.ConfirmChoiceCommand;
import com.smalaca.orderpreparation.command.application.shopping.ShoppingApplicationService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class ShoppingRestController {
    private final ShoppingApplicationService shoppingApplicationService;

    public ShoppingRestController(ShoppingApplicationService shoppingApplicationService) {
        this.shoppingApplicationService = shoppingApplicationService;
    }

    public UUID accept(AcceptShoppingCommand command) {
        return shoppingApplicationService.accept(command);
    }

    public UUID confirm(Map<UUID, Integer> products) {
        ConfirmChoiceCommand command = new ConfirmChoiceCommand(buyerId(), products);
        return shoppingApplicationService.confirm(command);
    }

    private UUID buyerId() {
        // get it from the session context
        return null;
    }
}
