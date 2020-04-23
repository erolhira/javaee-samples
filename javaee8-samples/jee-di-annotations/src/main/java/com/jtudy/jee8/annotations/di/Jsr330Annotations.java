package com.jtudy.jee8.annotations.di;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Qualifier;

/*
 * Dependency Injection for Java
 */
@Named //Jsr330
@Informal
public class Jsr330Annotations {
		
	@Inject
	//public Jsr330Annotations(@Named("TestObject") Provider<TestObj> testObjProvider) { //Jsr330
	public Jsr330Annotations(Provider<TestObj> testObjProvider) { //Jsr330
		TestObj testObj = testObjProvider.get();
		testObj.print();
	}
	
	public void execute() {
		System.out.println("Jsr330Annotations.execute");
	}
}

@Named("TestObject")
class TestObj {
	public void print() {
		System.out.println("TestObj.print");
	}
}

@Qualifier //Jsr330
@Retention(RUNTIME)
@Target({TYPE, METHOD, FIELD, PARAMETER})
@interface Informal {}