package com.sharefullcode.blopot.backendsavetoken.components;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
public class SecurityApp  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user1").password("{noop}123").roles("user");
        auth.inMemoryAuthentication().withUser("user2").password("{noop}123").roles("user");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests()
                .antMatchers("/user").hasRole("user")
                .antMatchers("/admin").hasRole("admin")
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated();
        http.cors().configurationSource(ConfigurationSource());
    }

    @Bean
    CorsConfigurationSource ConfigurationSource(){
        CorsConfiguration  cors = new CorsConfiguration();
        cors.addAllowedOrigin("*");
        cors.applyPermitDefaultValues();

        cors.addAllowedMethod(HttpMethod.PUT);
        UrlBasedCorsConfigurationSource url = new UrlBasedCorsConfigurationSource();
        url.registerCorsConfiguration("/**",cors);
        return url;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}

