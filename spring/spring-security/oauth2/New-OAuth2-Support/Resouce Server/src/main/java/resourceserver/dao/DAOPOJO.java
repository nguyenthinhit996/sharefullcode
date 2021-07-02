package resourceserver.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class DAOPOJO {

	public List<Student> ls = new ArrayList<>();

	DAOPOJO() {
		initalData();
	}

	void initalData() {
		Stream.iterate(0, i -> i + 1).limit(10).forEach(i -> {
			String name = "student" + String.valueOf(i);
			Student newStudent = new Student(name, i);
			ls.add(newStudent);
		});
	}

	public void editStudent(Student student) {
		ls.stream().filter(s-> s.getName().contains(student.getName())).findFirst().ifPresent(i->{
			i.setAge(student.getAge());
		});
	}
	
	public List<Student> addStudent(Student student) {
		ls.add(student);
		return ls;
	}

	void ouputStream() {
		System.out.println("------------ouputStream start------------------");
		ls.stream().forEach(System.out::println);
		System.out.println("------------- ouputStream end-----------------");
	}

//	public static void main(String[] args) {
//
//		DAOPOJO DAOPOJO = new DAOPOJO();
//		DAOPOJO.ouputStream();
//		
//		Student student = new Student("student3", 99);
//		DAOPOJO.editStudent(student);
//		
//		DAOPOJO.ouputStream();
//
//	 
//		
//	}
}
