package com.jtudy.jee7.jaxrsasyncdeferred.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class FacebookUser {
	
    private String name;
    private String username;
    private String locale;

    @JsonCreator
    public FacebookUser(@JsonProperty("name") String name,
                        @JsonProperty("username") String username,
                        @JsonProperty("locale") String locale) {
        this.name = name;
        this.username = username;
        this.locale = locale;
    }
}
