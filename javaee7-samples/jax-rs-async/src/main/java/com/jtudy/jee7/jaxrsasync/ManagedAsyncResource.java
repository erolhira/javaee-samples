package com.jtudy.jee7.jaxrsasync;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.stereotype.Component;

@Component
@Path("/managedasync")
public class ManagedAsyncResource {
	
	@GET @Path("/perform")
    @ManagedAsync
    public void asyncGet(@Suspended final AsyncResponse asyncResponse) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		asyncResponse.resume("long work done.");
    }
}
