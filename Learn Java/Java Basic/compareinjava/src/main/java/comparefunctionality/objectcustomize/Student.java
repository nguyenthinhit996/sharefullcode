package comparefunctionality.objectcustomize;

public class Student {

	private String name;
	private int age;
	private Float point;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Float getPoint() {
		return point;
	}
	public void setPoint(Float point) {
		this.point = point;
	}	
	
	Student(String name, int a, float f){
		this.age=a;
		this.name=name;
		this.point=f;
	}
}
