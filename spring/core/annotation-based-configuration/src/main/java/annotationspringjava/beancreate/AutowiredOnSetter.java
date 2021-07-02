package annotationspringjava.beancreate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import annotationspringjava.POJO.StudentPOJO;

@Component
public class AutowiredOnSetter {
	
	@Autowired
	void setObjectFromBean(StudentPOJO getObjectStudentPOJOByBean) {
		System.out.println("AutowiredOnSetter call Autowired " + getObjectStudentPOJOByBean.toString());
	}

	AutowiredOnSetter(){
		System.out.println("AutowiredOnSetter Constructor non argument");
	}
}
