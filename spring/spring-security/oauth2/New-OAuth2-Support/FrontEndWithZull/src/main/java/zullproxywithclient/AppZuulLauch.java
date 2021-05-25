package zullproxywithclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

 

@EnableZuulProxy
@SpringBootApplication
public class AppZuulLauch {
	


	public static void main(String[] args) throws Exception {
		 SpringApplication app = new SpringApplication(AppZuulLauch.class);
	      app.run();
	}


	
	@Bean
	ApplicationListener<ApplicationReadyEvent> onApplicationReadyEventListener(ServerProperties serverProperties) {

		return (evt) -> {

			Integer port = serverProperties.getPort();
			System.out.println("Running on port: " + port);
		};
	}
}
