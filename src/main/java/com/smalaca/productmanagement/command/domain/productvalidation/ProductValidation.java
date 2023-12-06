package com.smalaca.productmanagement.command.domain.productvalidation;

import com.smalaca.annotation.architecture.SecondaryPort;

@SecondaryPort
public interface ProductValidation {
    ProductValidationResponse verify(ProductDto productDto);
}
