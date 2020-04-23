package com.jtudy.jee8.annotations.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named("cdiAnnotations")
public class CdiAnnotations {

	@Inject
	private Car car;
		
	public void perform() {
		System.out.println("init of CdiAnnotations --> car: " + car.getBrand() + " - " + car.getModel());
	}
}
