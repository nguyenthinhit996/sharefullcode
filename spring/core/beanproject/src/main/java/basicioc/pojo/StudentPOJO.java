package basicioc.pojo;

public class StudentPOJO {
	
	private String name;
	private String nameClass;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameClass() {
		return nameClass;
	}
	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}
	
	public StudentPOJO() {
		this.name="default constructor";
		this.nameClass="default constructor";
	}
	
//	public StudentPOJO(String a, String b) {
//		this.name=a;
//		this.nameClass=b;
//	}
	
}
