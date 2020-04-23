package com.jtudy.cdi2;

import javax.inject.Inject;
import javax.inject.Named;

import com.jtudy.cdi2.model.Car;

@Named
public class EventController {

	@Inject @Named("Corsa")
	private Car opelCorsa;
	
	@Inject
	private CarService carService;
	
	public void openOpelCorsa() {
		carService.open(opelCorsa);
	}
	
	public void closeOpelCorsa() {
		carService.close(opelCorsa);
	}
}
