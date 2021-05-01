package com.minahotel.sourcebackend.enums;

public enum EnumTypeofroom {

	
	SINGLE("single"),
	DOUBLE("double"),
	VIP("vip");
	
	private String name;
	
	private EnumTypeofroom(String name) {
		 this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
