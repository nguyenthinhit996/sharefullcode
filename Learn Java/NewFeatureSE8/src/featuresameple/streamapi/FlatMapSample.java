package featuresameple.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class FlatMapSample {

	List<ClassRoom> classRoomList = new ArrayList<ClassRoom>();
	
	void createDataForList() {
		// Create data for list class room
		IntStream.range(1, 5).forEach(index -> {
			classRoomList.add(new ClassRoom(String.valueOf(index), "Class" + index));
		});

		// create student on class
		classRoomList.forEach(in -> {
			IntStream.range(1, 5).forEach(index -> {
				String nameStudent = "student " + index;
				in.getStudentList().add(new Student(index, nameStudent));
			});
		});

		// use flatMap to get stream of list Student
		classRoomList.stream().flatMap(s -> {
			System.out.println("Class: " + s.getIdClass());
			return s.getStudentList().stream();
		}).forEach(s -> {
			System.out.println(s);
		});

	}
	
	void optionalFlatMap() {
		// get str of inner class, check NullPoiterException
		OuterClass out = new OuterClass();
		if(out != null && out.nested != null && out.nested.inner != null) {
			System.out.println(out.nested.inner.str);
		}
		
		// use FlatMap with Optional same behavior code above
		Optional.of(new OuterClass())
				.flatMap(o->Optional.ofNullable(o.nested))
				.flatMap(nes -> Optional.ofNullable(nes.inner))
				.flatMap(in -> Optional.ofNullable(in.str))
				.ifPresent(System.out::println);
			 
		 
	}
	
	public static void main(String[] args) {
		FlatMapSample newObjectExample = new FlatMapSample();
		newObjectExample.optionalFlatMap();
	}
	
}


class ClassRoom {
	private String idClass;
	private String nameClas;
	private List<Student> studentList;
	
	ClassRoom(String id, String name){
		this.idClass=id;
		this.nameClas=name;
		studentList = new ArrayList<Student>();
	}	
	public String getIdClass() {
		return idClass;
	}
	public void setIdClass(String idClass) {
		this.idClass = idClass;
	}
	public String getNameClas() {
		return nameClas;
	}
	public void setNameClas(String nameClas) {
		this.nameClas = nameClas;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
}

class Student {
	private int idStudent;
	private String nameStudent;	
	
	public Student(int id, String name) {
		this.idStudent =id;
		this.nameStudent=name;
	}
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public String getNameStudent() {
		return nameStudent;
	}
	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}
	@Override
	public String toString(){
		return "id: " +idStudent +" Name: "+ nameStudent;
	}
}



class OuterClass {
	NestedClass nested;
}

class NestedClass {
	InnerClass inner;
}

class InnerClass {
	String str;
}

