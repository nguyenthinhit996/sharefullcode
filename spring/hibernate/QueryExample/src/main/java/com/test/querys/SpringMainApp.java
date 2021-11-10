package com.test.querys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringMainApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication();
        app.run(SpringMainApp.class);
    }
}
