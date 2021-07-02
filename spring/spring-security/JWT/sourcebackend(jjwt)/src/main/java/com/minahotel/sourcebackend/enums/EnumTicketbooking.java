package com.minahotel.sourcebackend.enums;

public enum EnumTicketbooking {

	
	IDTICKETBOOKING("idticketbooking"),
	IDUSERRENTROOM("iduserrentroom"),
	USERNAMERENTROOM("usernamerentroom"),
	TIMESTAMPRENT("timestamprent"),
	IDSTAFFRECEPTION("idstaffreception"),
	NUMBERROOM("numberroom"),
	TABLENAME("ticketbooking");
	
	private String name;
	
	private EnumTicketbooking(String name) {
		 this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
