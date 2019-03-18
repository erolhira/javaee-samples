package com.jtudy.jee7.jaxrs;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig() {
		register(Endpoint.class);
		//register(Endpoint2.class);
	}
}
