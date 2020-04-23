package com.jtudy.cdi2;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import com.jtudy.cdi2.ejb.LogService;
import com.jtudy.cdi2.ejb.LoginBean;
import com.jtudy.cdi2.model.Car;

/*
 * This is a managed bean but not a contextual instance.
 * When this bean is injected into an xhtml page then its context is Request Context since no scope is defined here.
 */
@Named("carController")
public class CarController {
	
	@Inject @Named("car")
	private Car defaultCar;	
	
	@Inject @Named("Corsa")
	private Car opelCorsa;

	@Inject
	private LogService logService;
	
	/*
	 * This is Cdi managed bean whose context is Session Context
	 */
	@Inject @Named("loginBean")
	private LoginBean login;
	
	/*
	 * This is EJB instance from LoginBean whose context is EJBContext
	 */
	@EJB
	private LoginBean loginBean;		
	
	public void drive() {
		logService.log("drive the car..");
	}
	
	public void login() {
		login.login();
	}		
	
	public void printUserInfo() {
		login.printName();
	}
	
	public void fromLoginEjb() {
		loginBean.fromLoginEjb();
		loginBean.printName();
	}		
	
	public Car getDefaultCar() {
		return defaultCar;
	}

	public Car getOpelCorsa() {
		return opelCorsa;
	}	
	
}
