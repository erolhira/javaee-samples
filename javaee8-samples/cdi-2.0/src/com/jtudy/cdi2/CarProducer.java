package com.jtudy.cdi2;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jtudy.cdi2.model.Car;

public class CarProducer {

	@Produces @SessionScoped @Named("Astra")
	public Car opelAstra() {
		return new Car("Opel", "Astra");
	}
	
	@Produces @RequestScoped @Named("Corsa")
	public Car opelCorsa() {
		return new Car("Opel", "Corsa");
	}
}
