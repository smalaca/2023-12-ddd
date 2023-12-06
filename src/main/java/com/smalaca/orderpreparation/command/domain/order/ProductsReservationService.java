package com.smalaca.orderpreparation.command.domain.order;

import java.util.List;
import java.util.UUID;

public interface ProductsReservationService {

    void book(List<ProductToBook> products);

    class ProductToBook {
        private UUID id;
        private int quantity;
    }

}
