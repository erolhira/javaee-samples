package com.jtudy.cdi2;

import javax.inject.Named;

@Named
public class PrintService {

	public void print(String text) {
		System.out.println(text);
	}
}
