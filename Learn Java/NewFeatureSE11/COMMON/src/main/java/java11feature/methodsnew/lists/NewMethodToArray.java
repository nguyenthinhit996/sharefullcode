package java11feature.methodsnew.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class NewMethodToArray {

	

	public static void main(String[] args) {

		List<Student> list = new ArrayList<Student>();

		Stream.iterate(0, i -> i < 10, i -> i + 1).forEach((i) -> {
			Student s = new Student(i);
			list.add(s);
		});
		Student[] list2 = list.toArray(Student[]::new);

		System.out.println(list2);
	}
}

class Student {

	private String name;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Student(int i) {
		this.name = String.valueOf(i);
		this.address = String.valueOf(i);
	}

}