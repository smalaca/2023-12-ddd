package com.smalaca.basket.infrastructure.repository.basket;

import com.smalaca.annotation.architecture.SecondaryAdapter;
import com.smalaca.basket.command.domain.basket.Basket;
import com.smalaca.basket.command.domain.basket.BasketRepository;

import java.util.UUID;

@SecondaryAdapter
public class SpringDataBasketRepository implements BasketRepository {
    @Override
    public Basket findById(UUID uuid) {
        return null;
    }

    @Override
    public void save(Basket basket) {

    }
}
