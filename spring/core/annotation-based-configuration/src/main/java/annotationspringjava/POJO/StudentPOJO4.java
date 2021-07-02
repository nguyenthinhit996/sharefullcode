package annotationspringjava.POJO;

public class StudentPOJO4 {

	private String name;
	private Integer age;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public StudentPOJO4(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("default StudentPOJO4 arugment");
	}

	public StudentPOJO4() {
		super();
		this.name = "default StudentPOJO4";
		this.age = 0;
		System.out.println("default StudentPOJO4 non arugment");
	}

	@Override
	public String toString() {
		return this.name+","+this.age;
	}
}
