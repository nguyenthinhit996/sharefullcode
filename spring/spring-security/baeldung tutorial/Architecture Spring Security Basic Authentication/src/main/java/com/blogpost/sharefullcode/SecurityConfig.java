package com.blogpost.sharefullcode;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.blogpost.sharefullcode.filter.CustomFilter;
import com.blogpost.sharefullcode.filter.MyBasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@ComponentScan("com.blogpost.sharefullcode.*")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	  @Autowired
	   private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("user1").password(passwordEncoder().encode("abc"))
          .authorities("ROLE_USER");
        
        auth.inMemoryAuthentication()
        .withUser("user2").password(passwordEncoder().encode("abc"))
        .authorities("ROLE_ADMIN");
        
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/user/***").hasAnyRole("USER")
          .antMatchers("/home").permitAll()
          .anyRequest().authenticated()
          .and()
          .httpBasic()
          .authenticationEntryPoint(authenticationEntryPoint);
          
  
//		http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
	
		// use multi antMatcher phai du phong /** o cuoi
//		http.antMatcher("/api/user/**")
//				.authorizeRequests()
//				.antMatchers("/api/user/").hasAnyRole("USER")
//				.antMatchers("/api/user/vip").hasAnyRole("USER","ADMIN")
//				
//			.and()
//			.antMatcher("/api/admin/**")
//			.authorizeRequests()
//			.antMatchers("/api/admin/").hasRole("ADMIN")
//			.antMatchers("/api/admin/vip").hasAnyRole("ADMIN")
//			
//			.and()
//			.antMatcher("/**").authorizeRequests().anyRequest().authenticated()
//			.and()
//			.formLogin();  
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return  PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
	
	// fix Can not find the tag library descriptor for "http://www.springframework.org/security/tags"
	 
}
