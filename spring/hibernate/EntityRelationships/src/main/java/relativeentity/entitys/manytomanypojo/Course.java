package relativeentity.entitys.manytomanypojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@Column(name= "id")
	private long idCourse;
	
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(mappedBy = "dsCourse")
	List<Student> dsStudent;

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
	 * @return the dsStudent
	 */
	public List<Student> getDsStudent() {
		return dsStudent;
	}

	/**
	 * @param dsStudent the dsStudent to set
	 */
	public void setDsStudent(List<Student> dsStudent) {
		this.dsStudent = dsStudent;
	}

	public Course() {
		super();
	}

	@Override
	public String toString() {
		return "Course [idCourse=" + idCourse + ", name=" + name + "]";
	}
	
	
}
