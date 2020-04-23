package com.jtudy.cdi2.ejb;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import com.jtudy.cdi2.model.User;

@Stateful @SessionScoped @Named("loginBean")
public class LoginBean implements Serializable {

	@Inject
	private User user;
	
	public void login(){
		user.setName("erol.hira");
	}
	
	public void printName() {
		System.out.println(user.getName());
	}
	
	public void fromLoginEjb() {
		System.out.println("from login ejb");
	}
}
