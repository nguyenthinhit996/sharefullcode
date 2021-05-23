package resourceserver.securityrest;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SercurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		
		 http
		 .antMatcher("/**").authorizeRequests()
		 .antMatchers(HttpMethod.GET, "/api/student","/api/infoserver").hasAuthority("SCOPE_read")
		 .antMatchers(HttpMethod.PUT, "/api/student").hasAuthority("SCOPE_write")
		 .antMatchers(HttpMethod.POST, "/api/student").hasAuthority("SCOPE_write")
		 .anyRequest().authenticated()
		 .and()
		 .oauth2ResourceServer().jwt();
	
		 http.cors().configurationSource(corsConfigurationSource());
		 http.addFilterBefore(new FilterCustomCors(), CorsFilter.class);
	}
	
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("http://localhost:8089");
		corsConfiguration.applyPermitDefaultValues();
		//customize defaut
		corsConfiguration.addAllowedMethod(HttpMethod.PUT);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration);
		return source;
	}
	
	@Bean
	public JwtDecoder customJwtDecode(OAuth2ResourceServerProperties properties) {
		NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(properties.getJwt().getJwkSetUri()).build();
		jwtDecoder.setClaimSetConverter(new OrganizationSubClaimAdapter());
		return jwtDecoder;
	}
	
}
	

