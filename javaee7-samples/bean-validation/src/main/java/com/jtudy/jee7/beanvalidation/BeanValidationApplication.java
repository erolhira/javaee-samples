package com.jtudy.jee7.beanvalidation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/*
 * https://beanvalidation.org/ --> official website
 * https://beanvalidation.org/2.0/spec/
 * https://jcp.org/en/jsr/detail?id=349 --> jsr page
 * https://www.baeldung.com/javax-validation
 * https://docs.oracle.com/javaee/7/api/javax/validation/constraints/package-summary.html
 * 
 * It's important to look for Bean Validation integration when selecting a UI framework or a persistence framework. 
 * JSF version 2 and Hibernate automatically integrates with Bean Validation, for example.
 * 
 * - You don't have to manually validate instances before passing them to Hibernate for storage.
 * - Hibernate recognizes constraints on persistent domain model classes and triggers validation 
 * before database insert or update operations. When validation fails, Hibernate throws a ConstraintViolationException, 
 * containing the failure details, to the code calling persistence-management operations.
 * 
 * some features of bean validation:
 * - class level validation
 * - method level validation
 * - integration with CDI
 * - error message interpolation using the EL expressions
 */
public class BeanValidationApplication {

	public static void main(String[] args) {
		
		Bill bill = new Bill();
		bill.setCurrency("TL");
		bill.setPrice(121312.11D);
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Bill>> violations = validator.validate(bill);
		for(ConstraintViolation<Bill> violation : violations) {
			System.out.println(violation.getMessage());
		}
	}

}
