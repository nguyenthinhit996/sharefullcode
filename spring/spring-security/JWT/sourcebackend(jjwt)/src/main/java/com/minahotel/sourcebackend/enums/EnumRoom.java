package com.minahotel.sourcebackend.enums;

public enum EnumRoom {

	idroom("idroom"),
	status("status"),
	nametyperoom("nametyperoom"),
	TABLENAME("room");
	
	private String name;
	
	private EnumRoom(String name) {
		 this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
}
