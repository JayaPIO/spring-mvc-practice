package com.jaya.springMVC_learning.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OfferCodeConstraintValidator implements ConstraintValidator<OfferCode, String> {
    private String prefix;

    @Override
    public void initialize(OfferCode offerCode) {
        prefix = offerCode.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if (code != null) {
            result = code.startsWith(prefix);
        } else {
            result = true;
        }
        return result;
    }
}
