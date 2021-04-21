package extrafieldlogin;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import extrafieldlogin.listener.AuthenticationFailureListener;
import extrafieldlogin.listener.AuthenticationSuccessListener;

public class ServletCustomConfigurer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		// package root 
		root.scan("extrafieldlogin");
		ServletRegistration.Dynamic servlet = servletContext.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
		root.register(SpringSecurityConfig.class);
		
		servletContext.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain")).addMappingForUrlPatterns(null, false, "/*");	
		servletContext.addListener(new ContextLoaderListener(root));
		// That's about it – we've defined this new RequestContextListener in our web.xml
		// to be able to access the request from the UserDetailsService.
		servletContext.addListener(new RequestContextListener());
	}

}
