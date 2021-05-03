package annotationspringjava.DAOUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import annotationspringjava.POJO.StudentPOJO;

public class DAOUtil {

	public static List<StudentPOJO> allStudent(){
		List<StudentPOJO> list = new ArrayList<StudentPOJO>();
		Stream.iterate(0,i->i+1).limit(10).forEach(i->{
			StudentPOJO student = new StudentPOJO(String.valueOf(i),i);
			list.add(student);
		});
		return list;
	}
}
