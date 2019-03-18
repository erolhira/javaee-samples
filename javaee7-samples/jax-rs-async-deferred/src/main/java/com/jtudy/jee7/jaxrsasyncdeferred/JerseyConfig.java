package com.jtudy.jee7.jaxrsasyncdeferred;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig() {
		register(AsyncResource.class);
	}
}
