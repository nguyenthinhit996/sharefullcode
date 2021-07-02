package annotationspringjava.beancreate;

import annotationspringjava.POJO.StudentPOJO4;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import annotationspringjava.POJO.StudentPOJO;
import annotationspringjava.POJO.StudentPOJO2;
import annotationspringjava.POJO.StudentPOJO3;

@Configuration
public class ConfigurationAnnotationCreate {

	@Bean
	StudentPOJO getObjectStudentPOJOByBean() {
		return new StudentPOJO(" bean-StudentPOJO",11111);
	}
	
	
	// tất cả các param phải là bean nếu ko sẽ báo lỗi khi gọi bean StudentPOJO2. (@Autowired StudentPOJO2 studentPOJO2;)
	//No qualifying bean of type 'annotationspringjava.POJO.StudentPOJO3' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
	@Bean //Demo lazy phải có bên @Autowired nữa mới hoạt động
	@Lazy
	StudentPOJO2 getObjectStudentPOJOByBeanWithParam(StudentPOJO j, StudentPOJO3 i) {
		System.out.println("auto bean call contructor "+ j.getName() +", "+ i.getName());
		return new StudentPOJO2(j.getName()+i.getName(),0);
	}


	//test Autowired on field
	@Bean
	StudentPOJO4 getObjectStudentPOJO4ByBean() {
			return new StudentPOJO4();
	}
}
