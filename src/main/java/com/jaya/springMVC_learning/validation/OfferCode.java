package com.jaya.springMVC_learning.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = OfferCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OfferCode {
    // Define default offer code
    String value() default "AT";

    // define default error message
    String message() default "must start with AT";

    // define default groups
    Class<?>[] groups() default {};

    // define default payloads
    Class<? extends Payload>[] payload() default {};
}
