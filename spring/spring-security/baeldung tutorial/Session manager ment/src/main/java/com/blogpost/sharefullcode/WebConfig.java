package com.blogpost.sharefullcode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.blogpost.sharefullcode.*" }) // scan contrller class
public class WebConfig implements WebMvcConfigurer {

	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// manual setting
		//registry.addMapping("/**")// CORS requests from any origin to any endpoint in the application.
//		allowed-origins="http://domain1.com, http://domain2.com"
//		allowed-methods="GET, PUT"
//		allowed-headers="header1, header2, header3"
//		exposed-headers="header1, header2" allow-credentials="false"
//		max-age="123"
		
		// use default setting by CorsConfiguration
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		registry.addMapping("/**") // CORS requests from any origin to any endpoint in the application.
		.combine(corsConfiguration.applyPermitDefaultValues());
	}
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/admin").setViewName("admin");
		registry.addViewController("/admin1").setViewName("admin1");
		registry.addViewController("/admin2").setViewName("admin2");
		registry.addViewController("/anonymous").setViewName("anonymous");
		registry.addViewController("/loginpage").setViewName("loginpage");
		registry.addViewController("/loginsuccess").setViewName("loginsuccess");
		registry.addViewController("/user").setViewName("user"); 
		registry.addViewController("/sessionExpired").setViewName("sessionExpired"); 
		registry.addViewController("/invalidSession").setViewName("invalidSession");
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
