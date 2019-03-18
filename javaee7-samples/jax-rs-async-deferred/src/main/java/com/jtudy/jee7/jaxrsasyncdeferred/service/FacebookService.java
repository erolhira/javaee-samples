package com.jtudy.jee7.jaxrsasyncdeferred.service;

import java.util.concurrent.Future;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.springframework.stereotype.Component;

import com.jtudy.jee7.jaxrsasyncdeferred.model.FacebookUser;

@Component
public class FacebookService {

    private final WebTarget target = 
    		ClientBuilder.newClient().target("http://graph.facebook.com/");

    public Future<FacebookUser> userAsync(String user) {
        return target
                .path("/{user}")
                .resolveTemplate("user", user)
                .request().async()
                .get(FacebookUser.class);
    }
}
