package com.smalaca.orderpreparation.command.domain.producttoorder;

public interface ProductsToOrderRepository {

    void save(ProductsToOrder order);

    ProductsToOrder read();
}
