package com.jtudy.jee7.jaxrsasync;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig() {
		register(AsyncResource.class);
		register(ManagedAsyncResource.class);
	}
}
