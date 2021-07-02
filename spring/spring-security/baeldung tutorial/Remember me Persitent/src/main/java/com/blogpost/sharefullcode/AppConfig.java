/**
 * 
 */
package com.blogpost.sharefullcode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan("com.blogpost.sharefullcode.*")
public class AppConfig implements WebMvcConfigurer{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/loginPage").setViewName("loginPage");
		registry.addViewController("/user").setViewName("user");
		registry.addViewController("/admin").setViewName("admin");
		registry.addViewController("/loginsucess").setViewName("loginsucess");
	}
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver in = new InternalResourceViewResolver();
		in.setViewClass(JstlView.class);
		in.setPrefix("/WEB-INF/views/");
		in.setSuffix(".jsp");
		return in;
	}
}
