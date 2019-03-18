package com.jtudy.jee7.jaxrsasyncdeferred.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class UserInfo {
	private FacebookUser facebookUser;
    private GitHubUser gitHubUser;
}
