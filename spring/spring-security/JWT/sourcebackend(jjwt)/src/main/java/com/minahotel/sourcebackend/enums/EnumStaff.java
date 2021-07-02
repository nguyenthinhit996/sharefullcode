package com.minahotel.sourcebackend.enums;

public enum EnumStaff {

	IDSTAFF("idstaff"),
	USERNAME("username"),
	PASS("pass"),
	ROLE("role"),
	DATEWORK("datework"),
	SALARYMONTH("salarymonth"),
	BONUSSALARY("bonussalary"),
	TABLENAME("staff");
	
	private String name;
	
	private EnumStaff(String name) {
		 this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
