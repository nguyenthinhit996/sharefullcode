package annotationspringjava.beancreate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import annotationspringjava.POJO.StudentPOJO;

@Component
public class AutowiredContructor {
	
	@Autowired
	AutowiredContructor(StudentPOJO getObjectStudentPOJOByBean){
		System.out.println("Autowired on Contructor "+ getObjectStudentPOJOByBean.toString());
	}

}
