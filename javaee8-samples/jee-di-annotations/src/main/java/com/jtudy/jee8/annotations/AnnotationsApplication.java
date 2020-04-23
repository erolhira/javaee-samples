package com.jtudy.jee8.annotations;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.jtudy.jee8.annotations.cdi.CdiAnnotations;
import com.jtudy.jee8.annotations.commonannotations.Jsr250Annotations;
import com.jtudy.jee8.annotations.di.Jsr330Annotations;

import lombok.Getter;

@SpringBootApplication
public class AnnotationsApplication {

	@Autowired
	private ApplicationContext applicationContext;

	@Getter
	@Resource // Jsr250
	private Jsr250Annotations jsr250;

	@Getter
	@Inject // Jsr330
	private Jsr330Annotations jsr330;
	
	@Getter
	@Inject
	private CdiAnnotations cdiAnnotations;

	public static void main(String[] args) {
		SpringApplication.run(AnnotationsApplication.class, args);
	}	

	@Bean
	public CommandLineRunner run() {
		testJsr250Annotations();
		testJsr330Annotations();
		testCdiAnnotations();
		return (args) -> {
		};
	}

	private void testJsr330Annotations() {
		jsr330.execute();
	}

	private void testJsr250Annotations() {
		jsr250.generatedMethod();
		// removeBeanFromContext("jsr250"); //to test @PreDestory
	}

	private void testCdiAnnotations() {
		cdiAnnotations.perform();
	}
	
	private void removeBeanFromContext(String beanName) {
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) applicationContext.getAutowireCapableBeanFactory();
		registry.removeBeanDefinition(beanName);
	}

}
