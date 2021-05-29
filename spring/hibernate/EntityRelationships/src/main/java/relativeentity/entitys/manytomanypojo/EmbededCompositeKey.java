package relativeentity.entitys.manytomanypojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmbededCompositeKey implements Serializable{

	@Column(name="student_id")
	private long idStudent;
	
	@Column(name="course_id")
	private long idCourse;

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

	public EmbededCompositeKey() {
		super();
	}

	@Override
	public String toString() {
		return "EmbededCompositeKey [idStudent=" + idStudent + ", idCourse=" + idCourse + "]";
	}
	
	
}
