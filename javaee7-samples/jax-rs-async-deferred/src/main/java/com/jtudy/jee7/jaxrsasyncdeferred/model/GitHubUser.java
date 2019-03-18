package com.jtudy.jee7.jaxrsasyncdeferred.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class GitHubUser {
    
	private final String login;
    private final String type;
    private final String name;
    
    @JsonCreator
    public GitHubUser(@JsonProperty("login") String login,
                      @JsonProperty("type") String type,
                      @JsonProperty("name") String name) {
        this.login = login;
        this.type = type;
        this.name = name;
    }
}
