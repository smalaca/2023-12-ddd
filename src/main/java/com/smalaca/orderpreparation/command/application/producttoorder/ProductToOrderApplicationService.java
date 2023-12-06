package com.smalaca.orderpreparation.command.application.producttoorder;

import java.util.UUID;

import com.smalaca.orderpreparation.command.domain.producttoorder.ProductsToOrder;
import com.smalaca.orderpreparation.command.domain.producttoorder.ProductsToOrderRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductToOrderApplicationService {

    private final ProductsToOrderRepository repository;

    public UUID approve(final ApproveCartCommand command) {
        ProductsToOrder productsToOrder = repository.read(command.getCartId());

        productsToOrder.approve(new Object());

        repository.save(productsToOrder);
        return null;
    }
}
