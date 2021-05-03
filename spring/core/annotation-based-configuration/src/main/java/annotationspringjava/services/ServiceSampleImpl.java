package annotationspringjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import annotationspringjava.DAO.IStudentSampleDAO;
import annotationspringjava.POJO.StudentPOJO;


@Service("serviceStudent")
public class ServiceSampleImpl implements IserviceSample{

	@Autowired 
	IStudentSampleDAO studentSampleDAO;
	
	
	@Override
	public Double AvegareAgeOfStudent() {
		List<StudentPOJO> ls = studentSampleDAO.getAllStudent();
		return ls.stream().mapToInt(student -> student.getAge()).average().orElse(-1);
	}

}
