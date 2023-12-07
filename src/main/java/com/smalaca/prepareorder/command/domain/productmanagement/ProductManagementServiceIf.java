package com.smalaca.prepareorder.command.domain.productmanagement;

import java.util.UUID;

public interface ProductManagementServiceIf {
    public ProductManagementResult reserveProduct(UUID productID, Integer amount);
}
