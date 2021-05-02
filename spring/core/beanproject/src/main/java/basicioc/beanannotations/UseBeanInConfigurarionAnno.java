package basicioc.beanannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseBeanInConfigurarionAnno {
	
	@Bean
	Pojobeanannotation getInterBeanReferences () {
		return new Pojobeanannotation();
	}
	
	// use factory-method from mode lite bean
	// from class normal has @Bean
	@Bean()
	UseBeanInClassNormal getLiteModeBeanByMethodFactor () {
		return new UseBeanInClassNormal();
	}
}
