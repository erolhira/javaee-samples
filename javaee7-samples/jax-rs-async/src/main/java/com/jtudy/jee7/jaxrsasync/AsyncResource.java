package com.jtudy.jee7.jaxrsasync;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import org.springframework.stereotype.Component;

@Component
@Path("/longwork")
public class AsyncResource {

	@Inject
	private Executor executor;
	
	/*
	 * A resource method that produces a response asynchronously must inject AsyncResponse using @Suspended annotation. 
	 * In the example above, response is not produced immediately, 
	 * but is forked to another thread and resource method returns immediately. 
	 * 
	 * http://localhost:8080/longwork/perform
	 */
	@GET @Path("/perform")
	public void asyncWork(@Suspended final AsyncResponse asyncResponse) {
		executor.execute(() -> {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			asyncResponse.resume("long work done.");
		});
	}
}
