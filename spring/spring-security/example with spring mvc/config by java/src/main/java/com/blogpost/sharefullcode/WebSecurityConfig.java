package com.blogpost.sharefullcode;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Order()
@ComponentScan("com.blogpost.sharefullcode")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
	public UserDetailsService userDetailsService() {
		 
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
				User.withDefaultPasswordEncoder().username("javatpoint").password("java123").roles("USER").build());
		return manager;
	}
	
	@Autowired
	  public void initialize(AuthenticationManagerBuilder builder, DataSource dataSource) throws Exception {
	    builder.jdbcAuthentication().dataSource(dataSource).withUser("dave")
	      .password("secret").roles("USER");
	  }

	protected void configure(HttpSecurity http) throws Exception {

//		http  
//		.authorizeRequests()  
//		.anyRequest().authenticated()  
//		.and()  
//		.httpBasic();  
		
		// login basic default of spring security
//		   http.antMatcher("/home").authorizeRequests().anyRequest().anonymous().and()
//		   .antMatcher("/index")                               
//	        .authorizeRequests()  
//	            .anyRequest().hasRole("USER")  
//	            .and().formLogin().and()  
//	        .httpBasic()  
//	        .and()  
//	        .logout()  
//	        .logoutUrl("/j_spring_security_logout")  
//	        .logoutSuccessUrl("/home")
//	        ;  
		
		//login customize
//		http.authorizeRequests().
//		antMatchers("/index", "/user","/").permitAll().
//		antMatchers("/admin").authenticated().and().formLogin().loginPage("/login").and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		//remember me
//		http.authorizeRequests().
//		antMatchers("/index", "/user","/").permitAll().
//		antMatchers("/admin").authenticated()
//		.and()
//		.formLogin().loginPage("/login")
//		.and()
//		.rememberMe().key("rem-mem-ber-me")
//		.rememberMeParameter("checkboxrememberme") // it is name of checkbox at login page  
//		.rememberMeCookieName("cookierememberlogin") // it is name of the cookie  
//		.tokenValiditySeconds(600) // remember for number of seconds  
//		.and()
//		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		 
		
	}
}
