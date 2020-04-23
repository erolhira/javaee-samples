package com.jtudy.cdi2.model;

import java.io.Serializable;

import javax.inject.Named;

@Named
public class Car implements Serializable {
	
	private String brand = "brand";
	private String model = "model";
	
	public Car() { }
	
	public Car(String brand, String model) { 
		this.brand = brand;
		this.model = model;
	}
	
	public String getName() {
		return brand + "." + model;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
		
}
