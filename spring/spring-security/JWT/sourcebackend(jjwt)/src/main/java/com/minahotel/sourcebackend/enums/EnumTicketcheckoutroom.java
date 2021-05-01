package com.minahotel.sourcebackend.enums;

public enum EnumTicketcheckoutroom {

	
	IDTICKETCHECKOUTROOM("idticketcheckoutroom"),
	IDTICKETBOOKING("idticketbooking"),
	TIMEENDRENT("timeendrent"),
	IDSTAFFRECEPTIONSUPPORT("idstaffreceptionsupport"),
	NUMBERROOMRENT("numberroomrent"),
	SUMARYRATESANDSERVICES("sumaryratesandservices"),
	TABLENAME("ticketcheckoutroom");
	
	private String name;
	
	private EnumTicketcheckoutroom(String name) {
		 this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
