package com.smalaca.orderpreparation.command.domain.productstoorder;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
@SecondaryPort
public interface ProductsToOrderRepository {
    ProductsToOrder findById(UUID productsToOrderId);
}
