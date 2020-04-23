package com.jtudy.jee8.annotations.commonannotations;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.processing.Generated;

/*
 * Common Annotations
 * A ManagedBean supports a small set of basic services such as resource injection, lifecycle callbacks and interceptors.
 */
@ManagedBean
public class Jsr250Annotations {
	
	/*
	 * @Generated can be used to mark sources that have been generated.
	 */
	@Generated("com.jtudy.CodeGenerator")
	public void generatedMethod() {
		System.out.println("Jsr250Annotations @Generated is called.");
	}
	
	@PostConstruct
	public void initialize() {
		System.out.println("Jsr250Annotations @PostConstruct is called.");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Jsr250Annotations @PreDestroy is called.");
	}
	
}
