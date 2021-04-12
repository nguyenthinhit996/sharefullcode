package com.blogpost.sharefullcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.blogpost.sharefullcode.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService userDetailsService;
	
	public SecSecurityConfig() {
        super();
    }
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		  auth.inMemoryAuthentication()
//	        .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
//	        .and()
//	        .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//	        .and()
//	        .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//https://stackoverflow.com/questions/14303081/userdetails-getpassword-returns-null-in-spring-security-3-1-how-to-get-password
		auth.eraseCredentials(false);
		auth.userDetailsService(userDetailsService);
	}
	// you can also config above
	//	@Bean("authenticationManager")
	//	@Override
	//	public AuthenticationManager authenticationManagerBean() throws Exception {
	//		
	//		return super.authenticationManagerBean();
	//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable()
		 .authorizeRequests() // control authorization request of client
		 .antMatchers("/admin/**").hasRole("ADMIN") // specific rule access /admin only user role admin 
		 .antMatchers("/anonymous*").anonymous() // specific rule access link /anonymous only user anonymous, user was autheticated access forbiden 
		 .antMatchers("/index").permitAll() // accept access all user from unauthenticated to authenticated
		 .antMatchers("/loginpage*").permitAll() // accept access all user from unauthenticated to authenticated
		 .anyRequest().authenticated() // the access link other is authenticated
		 .and()
		 .formLogin()
		 .loginPage("/loginpage")
		 .loginProcessingUrl("/login")
//		 .defaultSuccessUrl("/loginsuccess")
		 .failureUrl("/loginpage?error=true")
		 .successHandler(myAuthenticationSuccessHandler())
//		 .failureHandler(new AuthenticationFailureHandler() {
//			 @Override
//			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//					AuthenticationException exception) throws IOException, ServletException {
//				System.out.println("some act with handler failure handler");
//			}
//		 })
		 .and()
		 .logout()
	      .logoutUrl("/logout")
	      .logoutSuccessUrl("/index")
	      .deleteCookies("JSESSIONID");
//	      .logoutSuccessHandler(new LogoutSuccessHandler() {
//
//			@Override
//			public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
//					Authentication authentication) throws IOException, ServletException {
//				System.out.println("some act with handler logout handler");
//			}
//	    	  
//	      });
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	    return new MyLoginAuthenticationSuccessHandler();
	}
}
