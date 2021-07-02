package com.minahotel.sourcebackend.enums;

public enum EnumDailyworking {

	IDTODAY("idtoday"),
	IDSTAFFWORK("idstaffwork"),
	TIMESTART("timestart"),
	TIMEEND("timeend"),
	NOTE("note"),
	IDSTAFFMANAGEMENT("idstaffmanagement"),
	TABLENAME("dailyworking");
	
	private String name;
	
	private EnumDailyworking(String name) {
		 this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
