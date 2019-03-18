package com.jtudy.jee7.beanvalidation;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

/*
 * https://www.baeldung.com/javax-validation
 * https://docs.oracle.com/javaee/7/api/javax/validation/constraints/package-summary.html
 */
@Data
public class Bill {
	
	
	@NotNull(message="price cannot be empty")
	@Digits(integer=4, fraction=2, message="max 4 integer digits with max 2 of fractions are allowed..")
	private Double price;
	
	@NotNull(message="currency cannot be empty") 
	@Pattern(regexp="[A-Z]+", message="only upper case allowed")
	private String currency;
	
	@CustomValidation(message="custom validation failed for email field.")
	private String email = "invalid email";
	
	@CustomValidation(message="custom validation failed for email field.")
	private String email2 = "0";
	
}
