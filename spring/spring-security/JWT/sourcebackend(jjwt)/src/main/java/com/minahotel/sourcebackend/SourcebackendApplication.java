package com.minahotel.sourcebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.minahotel.sourcebackend.*")
public class SourcebackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SourcebackendApplication.class, args);
	}

}
