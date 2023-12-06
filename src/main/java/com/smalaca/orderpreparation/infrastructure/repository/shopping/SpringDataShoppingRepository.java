package com.smalaca.orderpreparation.infrastructure.repository.shopping;

import com.smalaca.annotation.architecture.SecondaryAdapter;
import com.smalaca.orderpreparation.command.domain.shopping.Shopping;
import com.smalaca.orderpreparation.command.domain.shopping.ShoppingRepository;

import java.util.UUID;

@SecondaryAdapter
public class SpringDataShoppingRepository implements ShoppingRepository {
    @Override
    public Shopping findById(UUID shoppingId) {
        return null;
    }

    @Override
    public UUID save(Shopping shopping) {
        return null;
    }
}
