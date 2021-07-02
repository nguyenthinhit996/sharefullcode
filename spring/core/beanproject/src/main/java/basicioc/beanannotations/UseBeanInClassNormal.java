package basicioc.beanannotations;

import org.springframework.context.annotation.Bean;


public class UseBeanInClassNormal {
	
	@Bean
	Pojobeanannotation getBeanInNormalClassOrNotConfigAnnoClass() {
		return new Pojobeanannotation();
	}
}
