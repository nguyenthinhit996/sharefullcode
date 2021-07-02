package com.minahotel.sourcebackend.enums;

public enum EnumDetailservicesStatus {

	PREPARE("Prepare"),
	SHIPPING("Shipping"),
	TODO("ToDo"),
	DONE("Done"),
	CANCEL("Cancel");
	
	private String name;
	
	private EnumDetailservicesStatus(String name) {
		 this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
