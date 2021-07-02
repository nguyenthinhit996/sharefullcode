package relativeentity.hibernateconfiguration.entitys;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "studentp")
public class CompositeStudent {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStudent;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;

	@OneToMany(mappedBy = "studentss")
//	private List<Student_Course> dsStuCourseDDD;
	// switch to manytomany cách 3 sử dụng new entity
	@OrderBy("idTrungGiang desc") // cột idTrungGiang sẽ giảm dần trong object CompositeCourse
	private List<Student_Course_NewID> dsStuCourseDDD;

	/**
	 * @return the idStudent
	 */
	public long getIdStudent() {
		return idStudent;
	}

	/**
	 * @param idStudent the idStudent to set
	 */
	public void setIdStudent(long idStudent) {
		this.idStudent = idStudent;
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
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the dsStuCourseDDD
	 */
//	public List<Student_Course> getDsStuCourseDDD() {
//		return dsStuCourseDDD;
//	}
	// switch to manytomany cách 3 sử dụng new entity
	public List<Student_Course_NewID> getDsStuCourseDDD() {
		return dsStuCourseDDD;
	}

	/**
	 * @param dsStuCourseDDD the dsStuCourseDDD to set
	 */
//	public void setDsStuCourseDDD(List<Student_Course> dsStuCourseDDD) {
//		this.dsStuCourseDDD = dsStuCourseDDD;
//	}
	// switch to manytomany cách 3 sử dụng new entity
	public void setDsStuCourseDDD(List<Student_Course_NewID> dsStuCourseDDD) {
		this.dsStuCourseDDD = dsStuCourseDDD;
	}

	public CompositeStudent() {
		super();
	}

	@Override
	public String toString() {
		return "CompositeStudent [idStudent=" + idStudent + ", name=" + name + ", age=" + age + "]";
	}

}
