package com.smalaca.prepareorder.infrastructure.db;

import com.smalaca.prepareorder.command.domain.disposition.Disposition;
import com.smalaca.prepareorder.command.domain.disposition.DispositionRepository;
import com.smalaca.prepareorder.command.domain.shopping.Shopping;
import com.smalaca.prepareorder.command.domain.shopping.ShoppingRepository;

import java.util.UUID;

public class SpringDataShoppingRepository implements ShoppingRepository {
    @Override
    public Shopping findById(UUID uuid) {
        return null;
    }

    @Override
    public void save(Shopping assortment) {}
}
