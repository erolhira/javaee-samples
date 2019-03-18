package com.jtudy.jee7.jaxrsasyncdeferred;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/*
 * https://allegro.tech/2014/10/async-rest.html
 */
@SpringBootApplication
@EnableAsync
public class JaxRsAsyncDeferredApplication {

	@Bean
    public TaskExecutor asyncTaskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(4);
        pool.setThreadGroupName("asyncExecutor");
        return pool;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(JaxRsAsyncDeferredApplication.class, args);
	}
}
