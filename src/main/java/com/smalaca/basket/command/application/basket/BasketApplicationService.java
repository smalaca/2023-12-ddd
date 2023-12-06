package com.smalaca.basket.command.application.basket;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.basket.command.domain.basket.Basket;
import com.smalaca.basket.command.domain.basket.BasketRepository;

@PrimaryAdapter
public class BasketApplicationService {
    private final BasketRepository repository;

    public BasketApplicationService(BasketRepository repository) {
        this.repository = repository;
    }

    public void addProduct(AddProductCommand command) {
        Basket basket = repository.findById(command.basketId());

        basket.addProduct();

        repository.save(basket);
    }

    public void removeProduct(RemoveProductCommand command) {
        Basket basket = repository.findById(command.basketId());

        basket.removeProduct();

        repository.save(basket);
    }
}
