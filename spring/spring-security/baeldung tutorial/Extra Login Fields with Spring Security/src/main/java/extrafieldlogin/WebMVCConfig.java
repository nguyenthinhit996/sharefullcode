package extrafieldlogin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({"extrafieldlogin.*"})
public class WebMVCConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/user/index").setViewName("user");
		registry.addViewController("/error").setViewName("error");
	}
	
	@Bean
	ViewResolver viewResolver() {
		InternalResourceViewResolver in = new InternalResourceViewResolver();
		in.setViewClass(JstlView.class);
		in.setPrefix("/WEB-INF/views/");
		in.setSuffix(".jsp");
		return in;
	}
	
}
