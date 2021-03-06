package extrafieldlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import extrafieldlogin.filter.SimpleAuthenticationFilter;
import extrafieldlogin.listener.CustomAuthenticationFailureHandler;
import extrafieldlogin.listener.CustomSpringEventPublisherAuthentication;
import extrafieldlogin.simpleextrafield.SimpleUserDetailServices;

@Configuration
@EnableWebSecurity
@ComponentScan("extrafieldlogin.*")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	SimpleUserDetailServices userDetailService;
	
//	@Autowired
//	AuthenticationEventPublisher customSpringEventPublisherAuthentication;
	
	@Autowired
	void congigureGlobal(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
		//use default for DefaultAuthenticationEventPublisher or CustomSpringEventPublisherAuthentication
		auth.authenticationEventPublisher(authenticationEventPublishers());
//		auth.authenticationEventPublisher(customSpringEventPublisherAuthentication);
		//------------
	 
	}
	
//  use default for DefaultAuthenticationEventPublisher or use create class CustomSpringEventPublisherAuthentication
//	@Bean
//    public DefaultAuthenticationEventPublisher authenticationEventPublishers() {
//        return new DefaultAuthenticationEventPublisher();
//    }
	
	
	@Bean
	  public CustomSpringEventPublisherAuthentication authenticationEventPublishers() {
	      return new CustomSpringEventPublisherAuthentication();
	  }

	 @Autowired 
	 PasswordEncoder passwordEncoder;


	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
        provider.setPasswordEncoder(passwordEncoder);
         
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests().antMatchers("/css/**", "/index","/error").permitAll().antMatchers("/user/**")
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")).deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/");
	}
	


	public SimpleAuthenticationFilter authenticationFilter() throws Exception {
		SimpleAuthenticationFilter simplefilter = new SimpleAuthenticationFilter();
		simplefilter.setAuthenticationManager(authenticationManagerBean());
		simplefilter.setAuthenticationFailureHandler(failureHandler());
		return simplefilter;
	}

	public SimpleUrlAuthenticationFailureHandler failureHandler() {
		return new CustomAuthenticationFailureHandler();
	}

}
