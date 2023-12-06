package com.smalaca.orderpreparation.infrastructure.repository.productstoorder;

import com.smalaca.annotation.architecture.SecondaryAdapter;
import com.smalaca.orderpreparation.command.domain.productstoorder.ProductsToOrder;
import com.smalaca.orderpreparation.command.domain.productstoorder.ProductsToOrderRepository;

import java.util.UUID;

@SecondaryAdapter
public class SpringDataProductsToOrderRepository implements ProductsToOrderRepository {
    @Override
    public ProductsToOrder findById(UUID productsToOrderId) {
        return null;
    }

    @Override
    public UUID save(ProductsToOrder productsToOrder) {
        return null;
    }
}
