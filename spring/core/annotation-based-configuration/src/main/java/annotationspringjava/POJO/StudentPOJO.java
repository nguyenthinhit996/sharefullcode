package annotationspringjava.POJO;

public class StudentPOJO {
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
	public StudentPOJO(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public StudentPOJO() {
		super();
		this.name = "default StudentPOJO";
		this.age = 0;
	}

	@Override
	public String toString() {
		return this.name+","+this.age;
	}
}
