package annotationspringjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import annotationspringjava.POJO.StudentPOJO2;
import annotationspringjava.services.IserviceSample;

@Controller
public class AppController {
	
	@Autowired()
	IserviceSample serviceSample;
	
	
	// test call  @bean has argument method , lỗi do 1 trong những đối số ko phải là bean . 
	// Demo lazy phải có bên bean nữa mới hoạt động
	@Lazy
	@Autowired 
	StudentPOJO2 studentPOJO2;
	
	public void getAvagraveOfStudent() {
		System.out.println("Avagare of student is: "+ serviceSample.AvegareAgeOfStudent());
		
		
		// error bởi vì được gọi , nếu rem lại thì lazy sẽ không tạo bean nên ko lỗi. 
		// System.out.println(studentPOJO2.getName());
	}
	
	
}
