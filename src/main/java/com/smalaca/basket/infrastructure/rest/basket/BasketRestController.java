package com.smalaca.basket.infrastructure.rest.basket;

import com.smalaca.basket.command.application.basket.AddProductCommand;
import com.smalaca.basket.command.application.basket.BasketApplicationService;
import com.smalaca.basket.command.application.basket.RemoveProductCommand;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasketRestController {
    private final BasketApplicationService basketApplicationService;

    public BasketRestController(BasketApplicationService basketApplicationService) {
        this.basketApplicationService = basketApplicationService;
    }

    public void addProduct(AddProductCommand command) {
        basketApplicationService.addProduct(command);
    }

    public void removeProduct(RemoveProductCommand command) {
        basketApplicationService.removeProduct(command);
    }
}
