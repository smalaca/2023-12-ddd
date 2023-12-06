package com.smalaca.orderpreparation.infrastructure.rest.productstoorder;

import com.smalaca.orderpreparation.command.application.productstoorder.ConfirmChoiceCommand;
import com.smalaca.orderpreparation.command.application.productstoorder.ProductsToOrderApplicationService;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProductsToOrderRestController {
    private final ProductsToOrderApplicationService productsToOrderApplicationService;

    public ProductsToOrderRestController(ProductsToOrderApplicationService productsToOrderApplicationService) {
        this.productsToOrderApplicationService = productsToOrderApplicationService;
    }

    public UUID accept(UUID productsToOrderId) {
        return productsToOrderApplicationService.accept(productsToOrderId);
    }

    public UUID confirm(ConfirmChoiceCommand command) {
        return productsToOrderApplicationService.confirm(command);
    }
}
