package com.smalaca.validation;

import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidatorExecutor {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public static <T> T validateAndReturn(final T objToValidate) {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> validate = validator.validate(objToValidate);
        if(validate.isEmpty()) {
            return objToValidate;
        }
        throw new IllegalStateException();
    }

}
