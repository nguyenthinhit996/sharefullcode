package basicioc.pojo;

public class StudentPOJO2 {
	
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
	
	
	public StudentPOJO2(String name, String nameClass) {
		super();
		this.name = name;
		this.nameClass = nameClass;
	}
	
//	public StudentPOJO2() {
//		super();
//		this.name = "defautl contrutor";
//		this.nameClass = "defautl contrutor";
//	}
//	
	public static StudentPOJO2 createInstance() {
		 return new StudentPOJO2("createInstance", "createInstance");
	}
}
