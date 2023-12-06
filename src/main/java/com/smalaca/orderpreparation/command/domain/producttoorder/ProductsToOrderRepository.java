package com.smalaca.orderpreparation.command.domain.producttoorder;

import java.util.UUID;

public interface ProductsToOrderRepository {

    void save(ProductsToOrder order);
    ProductsToOrder read(UUID uuid);

}
