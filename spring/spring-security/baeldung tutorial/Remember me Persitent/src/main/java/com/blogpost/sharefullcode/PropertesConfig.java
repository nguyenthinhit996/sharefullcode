package com.blogpost.sharefullcode;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({ "classpath:application.properties" })
public class PropertesConfig {
	@Autowired
	private Environment env;

	private static Environment environment;

	@PostConstruct
	public void init() {
		environment = env;
		System.out.println(environment == env);
	}

	public String getProperty(String property) {
		return environment.getProperty(property);
	}
}
