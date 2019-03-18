package com.jtudy.jee7.jaxrsasyncdeferred.service;

import java.util.concurrent.Future;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.jtudy.jee7.jaxrsasyncdeferred.model.GitHubUser;

@Service
public class GitHubService {

    private final WebTarget target = ClientBuilder.newClient().target("https://api.github.com/");

    public Future<GitHubUser> userAsync(String user) {
        return target
                .path("/users/{user}")
                .resolveTemplate("user", user)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .async()
                .get(GitHubUser.class);
    }
}
