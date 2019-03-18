package com.jtudy.jee7.beanvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<CustomValidation, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value == null) {
			return true;
		} else if(value.startsWith("0")) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("digit not allowed at the beginning.").addConstraintViolation();
			return false;
		}
		return false;
	}

}
