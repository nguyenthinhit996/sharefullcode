package relativeentity.hibernateconfiguration.entitys;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "coursep")
public class CompositeCourse {

	@Id
	@Column(name= "id")
	private long idCourse;
	
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "coursexxx")
//	private List<Student_Course> dsStuCourseFFF;
	//switch to manytomany cách 3 sử dụng new entity
	@OrderBy("idTrungGiang asc") // cột idTrungGiang sẽ tăng dần trong object CompositeCourse
	private List<Student_Course_NewID> dsStuCourseFFF;

	/**
	 * @return the idCourse
	 */
	public long getIdCourse() {
		return idCourse;
	}

	/**
	 * @param idCourse the idCourse to set
	 */
	public void setIdCourse(long idCourse) {
		this.idCourse = idCourse;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dsStuCourseFFF
	 */
//	public List<Student_Course> getDsStuCourseFFF() {
//		return dsStuCourseFFF;
//	}
	//switch to manytomany cách 3 sử dụng new entity
	public List<Student_Course_NewID> getDsStuCourseFFF() {
		return dsStuCourseFFF;
	}	
	

	/**
	 * @param dsStuCourseFFF the dsStuCourseFFF to set
	 */
//	public void setDsStuCourseFFF(List<Student_Course> dsStuCourseFFF) {
//		this.dsStuCourseFFF = dsStuCourseFFF;
//	}
	//switch to manytomany cách 3 sử dụng new entity
	public void setDsStuCourseFFF(List<Student_Course_NewID> dsStuCourseFFF) {
		this.dsStuCourseFFF = dsStuCourseFFF;
	}

	public CompositeCourse() {
		super();
	}

	@Override
	public String toString() {
		return "CompositeCourse [idCourse=" + idCourse + ", name=" + name + "]";
	}
}
