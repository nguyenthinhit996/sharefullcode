package com.blogpost.sharefullcode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.log.LogMessage;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import com.blogpost.sharefullcode.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Autowired
	HttpServletRequest request;
	
	public SecSecurityConfig() {
	 
        super();
    }
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//https://stackoverflow.com/questions/14303081/userdetails-getpassword-returns-null-in-spring-security-3-1-how-to-get-password
		auth.eraseCredentials(false);
		auth.userDetailsService(userDetailsService);
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable()
		 .authorizeRequests() // control authorization request of client
		 .antMatchers("/admin**").hasRole("ADMIN") // specific rule access /admin only user role admin 
		 .antMatchers("/anonymous*").anonymous() // specific rule access link /anonymous only user anonymous, user was autheticated access forbiden 
		 .antMatchers("/index","/sessionExpired","/invalidSession").permitAll() // accept access all user from unauthenticated to authenticated
		 .antMatchers("/loginpage*").permitAll() // accept access all user from unauthenticated to authenticated
		 .anyRequest().authenticated() // the access link other is authenticated
		 .and()
		 .formLogin()
		 .loginPage("/loginpage")
		 .loginProcessingUrl("/login")
		 .failureUrl("/loginpage?error=true")
		 .successHandler(myAuthenticationSuccessHandler())
		 .and()
		 .logout()
	     .logoutUrl("/logout")
	     .logoutSuccessUrl("/index")
	     .deleteCookies("JSESSIONID")
	     .and() // session managerment 
	     .sessionManagement()
	     .invalidSessionUrl("/invalidSession") // is called if timeout
	     .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // default
	     .maximumSessions(1) //To enable the scenario which allows multiple concurrent sessions, login in only one where 
	     .expiredUrl("/sessionExpired").expiredSessionStrategy(new CustomSessionInformationExpiredStrategy("/sessionExpired"));
	     	
	}
	
	 
	
	//Concurrent Session Control
	@Bean
	HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	    return new MyLoginAuthenticationSuccessHandler();
	}
	
	class CustomSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {

		private String urlExpired;
		
		CustomSessionInformationExpiredStrategy(String url){
			this.urlExpired =  url;
		}
		
		@Override
		public void onExpiredSessionDetected(SessionInformationExpiredEvent event)
				throws IOException, ServletException {
			HttpServletRequest httpServletRequest = event.getRequest();
			HttpServletResponse httpServletResponse = event.getResponse();
			RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(urlExpired);
			requestDispatcher.forward(httpServletRequest, httpServletResponse);
		}
		
	}
}
