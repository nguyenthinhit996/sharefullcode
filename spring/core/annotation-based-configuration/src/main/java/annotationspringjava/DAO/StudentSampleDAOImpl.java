package annotationspringjava.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import annotationspringjava.DAOUtil.DAOUtil;
import annotationspringjava.POJO.StudentPOJO;

@Repository
public class StudentSampleDAOImpl implements IStudentSampleDAO{

	public List<StudentPOJO> getAllStudent() {
		return DAOUtil.allStudent();
	}
}
