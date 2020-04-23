package com.jtudy.jee8.annotations.cdi;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import lombok.Data;

@Data
@Named
public class Car {
	
	private String brand;
	private String model;
	
	@PostConstruct
	public void init() {
		brand = "default brand";
		model = "default model";
	}
}
