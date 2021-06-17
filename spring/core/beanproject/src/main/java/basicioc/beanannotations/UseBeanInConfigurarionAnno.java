package basicioc.beanannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import basicioc.pojo.StudentPOJO;

@Configuration
public class UseBeanInConfigurarionAnno {
	
	@Autowired
	StudentPOJO ddddd;
	
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
