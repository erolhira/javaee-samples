package com.jtudy.jee7.jaxrs;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Component;

@Component
@Path("/print")
public class Endpoint {

	/*
	 * http://localhost:8080/print?input=thisisfromjersey
	 */
	@GET
	public String printMessage(@QueryParam("input") @NotNull String input) {
		return "printed --> " + input;
	}
}
