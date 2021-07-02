package com.minahotel.sourcebackend.enums;

public enum EnumDatework {


	IDDATEWORK("iddatework"),
	LISTUSERWORKFULLDAY("listuserworkfullday"),
	LISTUSERHALFDAY("listuserhalfday"),
	REGULATION("regulation"),
	TABLENAME("datework");
	
	private String name;
	
	private EnumDatework(String name) {
		 this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
