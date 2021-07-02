package com.minahotel.sourcebackend.enums;

public enum EnumTicketAndRoom {

	CLEAN("Clean"),
	ON("On"),
	OFF("Off");
	
	private String name;
	
	private EnumTicketAndRoom(String name) {
		 this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
