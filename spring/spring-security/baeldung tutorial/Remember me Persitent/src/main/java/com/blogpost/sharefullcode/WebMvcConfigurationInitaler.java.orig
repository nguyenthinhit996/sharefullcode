package com.blogpost.sharefullcode;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class WebMvcConfigurationInitaler implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		root.scan("com.blogpost");
		ServletRegistration.Dynamic servlet = servletContext.addServlet("mvc",
				new DispatcherServlet(new GenericWebApplicationContext()));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);

		// attach spring security into web application
		root.register(SpringSecurityConfiguration.class);
		servletContext.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
				.addMappingForUrlPatterns(null, false, "/*");

		servletContext.addListener(new ContextLoaderListener(root));
	}

}
