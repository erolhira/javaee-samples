package com.jtudy.jee7.jaxrsasync.client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;

public class JaxRsAsyncClientApplication {

	private static final WebTarget TARGET = ClientBuilder.newClient().target("http://localhost:8080");

	public static void main(String[] args) {

		TARGET
			.path("/managedasync/{action}")
			.resolveTemplate("action", "perform")
			.request()
			.async()
			.get(new InvocationCallback<String>() {
				@Override
				public void completed(String result) {
					System.out.println("on complete --> result: " + result);
				}

				@Override
				public void failed(Throwable throwable) {
					System.out.println("on fail --> ");
					throwable.printStackTrace();
				}
			});
		
		System.out.println("managedasync is called..");
	}

}
