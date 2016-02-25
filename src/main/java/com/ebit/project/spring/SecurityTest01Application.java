package com.ebit.project.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages="com.ebit.project.spring.controller")
public class SecurityTest01Application {

	public static void main(String[] args) {
		SpringApplication.run(SecurityTest01Application.class, args);
	}
}
