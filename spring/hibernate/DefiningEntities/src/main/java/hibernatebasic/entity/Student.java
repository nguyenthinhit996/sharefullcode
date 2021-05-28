package hibernatebasic.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name = "student")
public class Student {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(nullable = false,length = 50, name = "STUDENT_NAME", unique = false)
	private String name;
	
	@Transient
	private String fieldNotInDb;
	
	@Temporal(TemporalType.DATE)
	private Date birday;
	
	//chắn chắn phải có hàm khởi tạo không đối số
	Student(){
		super();
	}
}
