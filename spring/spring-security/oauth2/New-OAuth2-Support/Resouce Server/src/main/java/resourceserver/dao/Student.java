package resourceserver.dao;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8511502310946987685L;

	public Student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	
	public Student() {
		super();
	}



	public Student(Integer age,String name) {
		super();
		this.name = name;
		this.age = age;
	}

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

	@Override
	public String toString() {
		 return " name: " + name +" age: "+ age;
	}
	
	@Override
	public int hashCode() {
		 int code =31;
		 return this.name.hashCode() + this.age.hashCode() + code;
	}
	
	 public boolean equals(Object obj) {
	        if (obj instanceof Student) {
	            Student another = (Student) obj;
	            if (this.name.equals(another.name)) {
	                return true;
	            }
	        }
	        return false;
	    }
}
