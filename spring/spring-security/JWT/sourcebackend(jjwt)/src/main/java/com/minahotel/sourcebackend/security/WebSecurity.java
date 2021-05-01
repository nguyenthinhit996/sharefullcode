package com.minahotel.sourcebackend.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.minahotel.sourcebackend.security.filters.CustomValidationTokenHeaderFilter;
import com.minahotel.sourcebackend.security.filters.ExceptionHandlerFilterCustomize;
import com.minahotel.sourcebackend.security.filters.JwtAuthenticationEntryPoint;
import com.minahotel.sourcebackend.services.StaffRepositoryServices;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
    StaffRepositoryServices userDetailsService;	
	
	@Autowired
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	CustomValidationTokenHeaderFilter customValidationTokenHeaderFilter;
	
	@Autowired
	ExceptionHandlerFilterCustomize exceptionHandlerFilterCustomize;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http.cors().and().csrf().disable();
    	http.antMatcher("/**").authorizeRequests()
    	.antMatchers(SecurityConstants.SIGN_UP_URL
    			, SecurityConstants.RESET_PASS_URL
    			,SecurityConstants.RESET_TOKEN_URL).permitAll()
    	.anyRequest().authenticated()
    	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    	.and()
    	.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint); // handler error 
    	http.addFilterBefore(customValidationTokenHeaderFilter, UsernamePasswordAuthenticationFilter.class); // validation token header
    	http.addFilterBefore(exceptionHandlerFilterCustomize, CorsFilter.class);  // handler error runtime as expired jwt
    	
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());       
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
    	// TODO Auto-generated method stub
    	return super.authenticationManagerBean();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(false); //updated to false
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        source.registerCorsConfiguration("/**", config);
        return source;
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
