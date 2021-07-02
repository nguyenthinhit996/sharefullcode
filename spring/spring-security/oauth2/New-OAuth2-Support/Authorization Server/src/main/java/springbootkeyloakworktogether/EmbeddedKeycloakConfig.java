package springbootkeyloakworktogether;

import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import javax.naming.spi.InitialContextFactoryBuilder;
import javax.naming.spi.NamingManager;
import javax.sql.DataSource;
import javax.naming.Name;
import javax.naming.NameParser;
import javax.naming.CompositeName;



import org.jboss.resteasy.plugins.server.servlet.HttpServlet30Dispatcher;
import org.jboss.resteasy.plugins.server.servlet.ResteasyContextParameters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddedKeycloakConfig {

	@Bean
	ServletRegistrationBean keyCloakJaxRsApplication (KeycloakServerProperties keycloakServerProperties, DataSource dataSource) throws NamingException{
		
		mockJndiEnvironment(dataSource);
		EmbeddedKeycloakApplication.keycloakServerProperties = keycloakServerProperties;
		ServletRegistrationBean servlet = new ServletRegistrationBean<>(new HttpServlet30Dispatcher());
		servlet.addInitParameter("javax.ws.rs.Application", EmbeddedKeycloakApplication.class.getName());
		servlet.addInitParameter(ResteasyContextParameters.RESTEASY_SERVLET_MAPPING_PREFIX, keycloakServerProperties.getContextPath());
		servlet.addInitParameter(ResteasyContextParameters.RESTEASY_USE_CONTAINER_FORM_PARAMS, "true");
		servlet.addUrlMappings(keycloakServerProperties.getContextPath()+"/*");
		servlet.setLoadOnStartup(1);
		servlet.setAsyncSupported(true);
		return servlet;
	}
	
	@Bean
	FilterRegistrationBean keyCloakSessionManagement(KeycloakServerProperties keycloakServerProperties) {
		FilterRegistrationBean filter = new FilterRegistrationBean<>();
		filter.setName("Filter KeyCloak session managenent");
		filter.setFilter(new EmbededkeyCloakRequestFilter());
		filter.addUrlPatterns(keycloakServerProperties.getContextPath()+"/*");
		return filter;
	}
	
	 private void mockJndiEnvironment(DataSource dataSource) throws NamingException {	
		 
	        NamingManager.setInitialContextFactoryBuilder(
	          (env) -> (environment) -> new InitialContext() {
	            @Override
	            public Object lookup(Name name) {
	                return lookup(name.toString());
	            }
		
	            @Override
	            public Object lookup(String name) {
	                if ("spring/datasource".equals(name)) {
	                    return dataSource;
	                }
	                return null;
	            }

	            @Override
	            public NameParser getNameParser(String name) {
	                return CompositeName::new;
	            }

	            @Override
	            public void close() {
	            }
	        });
	    }
	
}
