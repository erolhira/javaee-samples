package com.jtudy.jee7.beanvalidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomValidator.class)
public @interface CustomValidation {
	
    String message() default "Validatable object couldn't be validated successfully for AddressValidation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
