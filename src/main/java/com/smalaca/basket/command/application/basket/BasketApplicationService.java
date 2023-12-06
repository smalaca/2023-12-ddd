package com.smalaca.basket.command.application.basket;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.basket.command.domain.basket.Basket;
import com.smalaca.basket.command.domain.basket.BasketRepository;
import org.springframework.transaction.annotation.Transactional;

@PrimaryAdapter
public class BasketApplicationService {
    private final BasketRepository repository;

    public BasketApplicationService(BasketRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void addProduct(AddProductCommand command) {
        Basket basket = repository.findById(command.basketId());

        basket.addProduct();

        repository.update(basket);
    }

    @Transactional
    public void removeProduct(RemoveProductCommand command) {
        Basket basket = repository.findById(command.basketId());

        basket.removeProduct();

        repository.update(basket);
    }
}
