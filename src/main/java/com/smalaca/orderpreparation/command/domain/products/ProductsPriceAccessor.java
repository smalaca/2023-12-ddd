package com.smalaca.orderpreparation.command.domain.products;

import com.smalaca.orderpreparation.sharedkernel.ProductId;
import com.smalaca.productsmanagement.command.domain.assortment.Price;

public interface ProductsPriceAccessor {

    // todo: price? shared kernel or other class
    Price get(ProductId productId);

}
