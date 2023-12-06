package com.smalaca.productmanagement.command.domain.productvalidation;

public interface ProductValidation {
    ProductValidationResponse verify(ProductDto productDto);
}
