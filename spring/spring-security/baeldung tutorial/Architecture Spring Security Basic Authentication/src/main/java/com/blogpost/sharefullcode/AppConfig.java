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
@ComponentScan({ "com.blogpost.sharefullcode.*" }) // scan contrller class
public class AppConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("indexuser"); move to controller class
		registry.addViewController("/home").setViewName("home");
		
		registry.addViewController("/api/user/").setViewName("indexuser");
		registry.addViewController("/api/user/vip").setViewName("vipuser");
		
		registry.addViewController("/api/admin/").setViewName("indexadmin");
		registry.addViewController("/api/admin/vip").setViewName("vipadmin");
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
	}
}
