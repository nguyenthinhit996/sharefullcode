package com.minahotel.sourcebackend.pojo.fontendsendto;

import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;

public class StatusServiceTableFontEnd extends MinaHoTelPojo{
	
	private String idstaff;
	private String username;
	private int numberroom;
	private String typeservices;
	private String status;
	private String idcheckingoutroomdamaded;
	private String idticketcheckoutroom;
	private String detailservicesIdticketbooking;
	private String detailservicesidproduct;
	public String getIdstaff() {
		return idstaff;
	}
	public void setIdstaff(String idstaff) {
		this.idstaff = idstaff;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getNumberroom() {
		return numberroom;
	}
	public void setNumberroom(int numberroom) {
		this.numberroom = numberroom;
	}
	public String getTypeservices() {
		return typeservices;
	}
	public void setTypeservices(String typeservices) {
		this.typeservices = typeservices;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIdcheckingoutroomdamaded() {
		return idcheckingoutroomdamaded;
	}
	public void setIdcheckingoutroomdamaded(String idcheckingoutroomdamaded) {
		this.idcheckingoutroomdamaded = idcheckingoutroomdamaded;
	}
	public String getIdticketcheckoutroom() {
		return idticketcheckoutroom;
	}
	public void setIdticketcheckoutroom(String idticketcheckoutroom) {
		this.idticketcheckoutroom = idticketcheckoutroom;
	}
	public String getDetailservicesIdticketbooking() {
		return detailservicesIdticketbooking;
	}
	public void setDetailservicesIdticketbooking(String detailservicesIdticketbooking) {
		this.detailservicesIdticketbooking = detailservicesIdticketbooking;
	}
	public String getDetailservicesidproduct() {
		return detailservicesidproduct;
	}
	public void setDetailservicesidproduct(String detailservicesidproduct) {
		this.detailservicesidproduct = detailservicesidproduct;
	}
	public StatusServiceTableFontEnd(String idstaff, String username, int numberroom, String typeservices,
			String status, String idcheckingoutroomdamaded, String idticketcheckoutroom,
			String detailservicesIdticketbooking, String detailservicesidproduct) {
		super();
		this.idstaff = idstaff;
		this.username = username;
		this.numberroom = numberroom;
		this.typeservices = typeservices;
		this.status = status;
		this.idcheckingoutroomdamaded = idcheckingoutroomdamaded;
		this.idticketcheckoutroom = idticketcheckoutroom;
		this.detailservicesIdticketbooking = detailservicesIdticketbooking;
		this.detailservicesidproduct = detailservicesidproduct;
	}
	public StatusServiceTableFontEnd() {
		super();
	}
	
	
}
