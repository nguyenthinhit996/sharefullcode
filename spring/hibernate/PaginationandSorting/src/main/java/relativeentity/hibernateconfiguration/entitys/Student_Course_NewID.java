package relativeentity.hibernateconfiguration.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "newid_student_course")
public class Student_Course_NewID {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long idTrungGiang;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private CompositeCourse coursexxx;
	
	@ManyToOne
	@JoinColumn(name =  "student_id")
	private CompositeStudent studentss;
	
	
	@Column(name = "point")
	private int pointOfStudent;

	// mục đích là sử dụng lại 2 khóa ngoại nên tạo ra 1 khóa chính 
	// lần thứ mấy đăng kí khóa học này
	@Column(name = "times")
	private Integer lan_thu_may_dang_ky;

	/**
	 * @return the idTrungGiang
	 */
	public long getIdTrungGiang() {
		return idTrungGiang;
	}



	/**
	 * @param idTrungGiang the idTrungGiang to set
	 */
	public void setIdTrungGiang(long idTrungGiang) {
		this.idTrungGiang = idTrungGiang;
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
	 * @return the lan_thu_may_dang_ky
	 */
	public Integer getLan_thu_may_dang_ky() {
		return lan_thu_may_dang_ky;
	}



	/**
	 * @param lan_thu_may_dang_ky the lan_thu_may_dang_ky to set
	 */
	public void setLan_thu_may_dang_ky(Integer lan_thu_may_dang_ky) {
		this.lan_thu_may_dang_ky = lan_thu_may_dang_ky;
	}



	public Student_Course_NewID() {
		super();
	}



	@Override
	public String toString() {
		return "Student_Course_NewID [idTrungGiang=" + idTrungGiang  + ", studentss="
				+ studentss + ", pointOfStudent=" + pointOfStudent + ", lan_thu_may_dang_ky=" + lan_thu_may_dang_ky
				+ "]";
	}
	
}
