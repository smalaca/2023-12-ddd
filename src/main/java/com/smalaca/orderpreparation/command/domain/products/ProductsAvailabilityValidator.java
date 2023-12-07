package com.smalaca.orderpreparation.command.domain.products;

import java.util.List;

import com.smalaca.orderpreparation.sharedkernel.Product;

public interface ProductsAvailabilityValidator {

    boolean isInvalid(List<Product> products);

}
