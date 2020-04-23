package com.jtudy.cdi2.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.jtudy.cdi2.PrintService;

@Stateless
public class LogService {

	@Inject
	private PrintService printService;
	
	public void log(String log) {
		printService.print(log);
	}
}
