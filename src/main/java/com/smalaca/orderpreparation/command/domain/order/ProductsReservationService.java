package com.smalaca.orderpreparation.command.domain.order;

import java.util.List;

import com.smalaca.orderpreparation.sharedkernel.Product;

public interface ProductsReservationService {

    void book(List<Product> products);

}
