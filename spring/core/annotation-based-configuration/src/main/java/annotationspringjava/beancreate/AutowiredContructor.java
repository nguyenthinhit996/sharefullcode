package annotationspringjava.beancreate;

import annotationspringjava.POJO.StudentPOJO2;
import annotationspringjava.POJO.StudentPOJO4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import annotationspringjava.POJO.StudentPOJO;

@Component
public class AutowiredContructor {



	AutowiredContructor(){
		System.out.println("AutowiredContructor Contructor non argument ");
	}


	AutowiredContructor(StudentPOJO2 getObjectStudentPOJOByBean){
		System.out.println("AutowiredContructor Contructor has argument");
	}

	@Autowired
	AutowiredContructor(StudentPOJO getObjectStudentPOJOByBean){
		System.out.println("AutowiredContructor Contructor @Autowired: "+ getObjectStudentPOJOByBean.toString());
	}

	//error only autowired constructor
//	@Autowired()
//	AutowiredContructor(StudentPOJO getObjectStudentPOJOByBean, int r){
//		System.out.println("Autowired on Contructor 2 "+ getObjectStudentPOJOByBean.toString());
//	}


}
