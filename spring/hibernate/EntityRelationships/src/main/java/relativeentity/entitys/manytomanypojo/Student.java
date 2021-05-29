package relativeentity.entitys.manytomanypojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStudent; 
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private Integer age;
	
	// nếu bật mode hibernate.hbm2ddl.auto= update thì sẽ tự tạo entity luôn không cần tạo table dưới Db
	// nếu không sẽ phải tự tạo 3 table luôn xem ảnh BasicManytoMany.webp
	// trong quan hệ many to many sẽ không có chủ sở hữu foreign key nên có thể đặt @Join table bên nào cũng dc
	@ManyToMany
	@JoinTable( 
			name = "student_course"
			,joinColumns = {@JoinColumn(columnDefinition = "student_id", referencedColumnName = "id")}
			,inverseJoinColumns = {@JoinColumn(columnDefinition = "course_id", referencedColumnName = "id")})
	private List<Course> dsCourse;


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
	 * @return the dsCourse
	 */
	public List<Course> getDsCourse() {
		return dsCourse;
	}


	/**
	 * @param dsCourse the dsCourse to set
	 */
	public void setDsCourse(List<Course> dsCourse) {
		this.dsCourse = dsCourse;
	}


	public Student() {
		super();
	}


	@Override
	public String toString() {
		return "Student [idStudent=" + idStudent + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
