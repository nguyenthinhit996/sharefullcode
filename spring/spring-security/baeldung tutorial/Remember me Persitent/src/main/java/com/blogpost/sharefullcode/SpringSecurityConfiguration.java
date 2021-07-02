package com.blogpost.sharefullcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import com.blogpost.sharefullcode.handler.LoginSuccessHandler;
import com.blogpost.sharefullcode.services.InitalDataBase;
import com.blogpost.sharefullcode.services.MyUserDetailServices;

@Configuration
@EnableWebSecurity
@ComponentScan("com.blogpost.sharefullcode.*")
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	InitalDataBase InitalDataBase;
	
	@Autowired
	PersistenceConfigJDBC persistenceConfigJDBC;
	
	@Autowired
	MyUserDetailServices myUserDetailServices;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.eraseCredentials(false);
		auth.userDetailsService(myUserDetailServices);
	}
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user").hasAnyRole("USER")
		.antMatchers("/admin").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/loginPage*").permitAll()
		.antMatchers("/").anonymous()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/loginPage")
		.loginProcessingUrl("/login")
		.failureUrl("/loginPage?error=true")
		.successHandler(myAuthenticationSuccessHandler())
		.and()
		.logout()
		.logoutUrl("/perform_logout") // /perform_logout ony view instead of /logout default
		.deleteCookies("JSESSIONID")
		.logoutSuccessUrl("/loginPage")
		.and()
		.rememberMe().key("myAppKey")
		.rememberMeParameter("cookie-login")
		.rememberMeCookieName("cookie-in-client")
		.tokenRepository(jdbcTokenRepository())
		.tokenValiditySeconds(120);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	    return new LoginSuccessHandler();
	}
	
//	@Bean("rememberMeAuthenticationProvider")
//	PersistentTokenBasedRememberMeServices rememberMeAuthenticationProvider() {
//		PersistentTokenBasedRememberMeServices cookie = new PersistentTokenBasedRememberMeServices("myAppKey", myUserDetailServices, jdbcTokenRepository());
//		return cookie;
//	}
	
	//https://ducmanhphan.github.io/2019-02-17-Remember-me-mechanism-in-Java-Spring/
	@Bean("jdbcTokenRepository")
	JdbcTokenRepositoryImpl jdbcTokenRepository() {
		JdbcTokenRepositoryImpl newObject = new JdbcTokenRepositoryImpl();
		newObject.setCreateTableOnStartup(false);
		newObject.setDataSource(persistenceConfigJDBC.dataSource());
		return newObject;
	}
}
