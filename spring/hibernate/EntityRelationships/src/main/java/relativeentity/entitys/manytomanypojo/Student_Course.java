package relativeentity.entitys.manytomanypojo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "composite_student_course")
public class Student_Course {
	
	@EmbeddedId
	EmbededCompositeKey id;
	
	// lưu ý chỗ này @JoinColumn(name =  "course_id") nêu sử dụng vậy thì đặt tên [private CompositeCourse coursexxx;]
	// coursexxx thoãi mái 
	// còn nếu sử dụng  
	// @JoinColumn(columnDefinition = "course_id", referencedColumnName = "id") 	
	// thì bắt buộc đăc tên có quy tăt là private CompositeCourse course; // bỏ hậu tố _id đi. xem onetone foriegn key chi tiet
	
	
	@ManyToOne
	@MapsId("idCourse")
	@JoinColumn(name = "course_id")
	private CompositeCourse coursexxx;
	
	@ManyToOne
	@MapsId("idStudent")
	@JoinColumn(name =  "student_id")
	private CompositeStudent studentss;
	
	
	
	@Column(name = "point")
	private int pointOfStudent;
	
	/**
	 * @return the id
	 */
	public EmbededCompositeKey getId() {
		return id;
	}

	 

	/**
	 * @return the coursexxx
	 */
	public CompositeCourse getCoursexxx() {
		return coursexxx;
	}



	/**
	 * @param coursexxx the coursexxx to set
	 */
	public void setCoursexxx(CompositeCourse coursexxx) {
		this.coursexxx = coursexxx;
	}



	/**
	 * @return the studentss
	 */
	public CompositeStudent getStudentss() {
		return studentss;
	}



	/**
	 * @param studentss the studentss to set
	 */
	public void setStudentss(CompositeStudent studentss) {
		this.studentss = studentss;
	}



	/**
	 * @return the pointOfStudent
	 */
	public int getPointOfStudent() {
		return pointOfStudent;
	}



	/**
	 * @param pointOfStudent the pointOfStudent to set
	 */
	public void setPointOfStudent(int pointOfStudent) {
		this.pointOfStudent = pointOfStudent;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(EmbededCompositeKey id) {
		this.id = id;
	}



	public Student_Course() {
		super();
	}



	@Override
	public String toString() {
		return "Student_Course [id=" + id + ", studentss=" + studentss
				+ ", pointOfStudent=" + pointOfStudent + "]";
	}
	
	
	
}
