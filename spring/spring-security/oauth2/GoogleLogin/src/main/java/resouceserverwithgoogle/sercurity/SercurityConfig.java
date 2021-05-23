package resouceserverwithgoogle.sercurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SercurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("thinh").password("{noop}abc").authorities("user");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
		 .antMatcher("/**").authorizeRequests()
		 	.antMatchers("/login").permitAll()
			 .antMatchers("/loginpage").permitAll()
			 .antMatchers("/success").permitAll()
			 .antMatchers("/faliure").permitAll()
			 
			 .antMatchers("/public/**").permitAll()
			 .anyRequest().authenticated() 
			 // link bất kì sẽ nhảy vào login, sau khi login thành công chuyển đến link đã truy cập trước đó
			 // trường hợp đang ở trang loginPage luôn thì sẽ nhảy vào trang defaultSuccessUrl("/success")
		 .and()
		 .oauth2Login().loginPage("/loginpage")
		 .defaultSuccessUrl("/success")
		 .failureUrl("/faliure")
		 .and()
		 .formLogin() // login normal
		 .loginProcessingUrl("/login")
		 .loginPage("/loginpage")
		 .defaultSuccessUrl("/")
		 .failureUrl("/faliure")
		 .and()
		 .logout().logoutSuccessUrl("/loginpage");
		 
		 http.csrf().disable();
		 http.cors().disable();
	}
	
}
