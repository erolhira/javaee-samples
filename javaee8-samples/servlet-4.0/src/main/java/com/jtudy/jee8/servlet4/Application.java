package com.jtudy.jee8.servlet4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan //to make embedded containers support @WebServlet, @WebFilter and @WebListener annotations.
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class}) //to enable container handle the error instead of whitelabel error page 
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
