package com.blogpost.sharefullcode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@ComponentScan("com.blogpost.sharefullcode")
public class WebSecurityConfig implements WebMvcConfigurer {
	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
				User.withDefaultPasswordEncoder().username("javatpoint").password("java123").roles("USER").build());
		return manager;
	}

	protected void configure(HttpSecurity http) throws Exception {
	
//		http  
//		.authorizeRequests()  
//		.anyRequest().authenticated()  
//		.and()  
//		.formLogin()  
//		.and()  
//		.httpBasic();  
		
		   http.antMatcher("/home").authorizeRequests().anyRequest().anonymous().and()
		   .antMatcher("/index")                               
	        .authorizeRequests()  
	            .anyRequest().hasRole("USER")  
	            .and().formLogin().and()  
	        .httpBasic()  
	        .and()  
	        .logout()  
	        .logoutUrl("/j_spring_security_logout")  
	        .logoutSuccessUrl("/home")
	        ;  
	}
}