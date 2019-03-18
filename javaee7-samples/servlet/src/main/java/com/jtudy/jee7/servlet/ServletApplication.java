package com.jtudy.jee7.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/*
 * Due to the fact that embedded containers do not support @WebServlet, @WebFilter and @WebListener annotations, 
 * Spring Boot, relying greatly on embedded containers, introduced this new annotation @ServletComponentScan 
 * to support some dependent jars that use these 3 annotations.
 */
@SpringBootApplication
@ServletComponentScan
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

}
