package com.jtudy.jee7.jaxrsasyncdeferred;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import com.jtudy.jee7.jaxrsasyncdeferred.model.FacebookUser;
import com.jtudy.jee7.jaxrsasyncdeferred.model.GitHubUser;
import com.jtudy.jee7.jaxrsasyncdeferred.model.UserInfo;
import com.jtudy.jee7.jaxrsasyncdeferred.service.FacebookService;
import com.jtudy.jee7.jaxrsasyncdeferred.service.GitHubService;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static javax.ws.rs.core.Response.Status.SERVICE_UNAVAILABLE;

@Component
@Path("/user")
public class AsyncResource {

	@Inject
	private FacebookService facebookService;

	@Inject
	private GitHubService gitHubService;

	@Inject
	private TaskExecutor executor;

	@GET
	@Path("/userInfo/{user}")
	@Produces(MediaType.APPLICATION_JSON)
	public void userInfoAsync(@Suspended AsyncResponse asyncResponse, @PathParam("user") String user) {

		CompletableFuture<GitHubUser> gitHubFuture = toCompletable(gitHubService.userAsync(user), executor);
		CompletableFuture<FacebookUser> facebookFuture = toCompletable(facebookService.userAsync(user), executor);

		gitHubFuture.thenCombine(facebookFuture, (g, f) -> new UserInfo(f, g))
				.thenApply(info -> asyncResponse.resume(info))
				.exceptionally(e -> asyncResponse.resume(Response.status(INTERNAL_SERVER_ERROR).entity(e).build()));

		asyncResponse.setTimeout(1000, TimeUnit.MILLISECONDS);
		asyncResponse.setTimeoutHandler(
				ar -> ar.resume(Response.status(SERVICE_UNAVAILABLE).entity("Operation timed out").build()));
	}

	public static <T> CompletableFuture<T> toCompletable(Future<T> future, Executor executor) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				return future.get();
			} catch (InterruptedException | ExecutionException e) {
				throw new RuntimeException(e);
			}
		}, executor);
	}
}
