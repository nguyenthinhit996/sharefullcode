package com.minahotel.sourcebackend.pojo;

import java.time.LocalDateTime;

public class DetailRoom extends MinaHoTelPojo{

	 private Boolean isEmpty;
	 private Boolean isFull;
     private Boolean isClean;
     private Integer numberRoom;	
     private String typeRoom;
     private LocalDateTime timeStartRent; 
	private LocalDateTime timeStartClean; 
     private String nameRent;
     private String nameCLean;
     private String timeRent;
     private String timeClean;
     private String idticketbooking;
     
     
     
     public String getIdticketbooking() {
		return idticketbooking;
	}
	public void setIdticketbooking(String idticketbooking) {
		this.idticketbooking = idticketbooking;
	}
	public LocalDateTime getTimeStartClean() {
		return timeStartClean;
	}
	public void setTimeStartClean(LocalDateTime timeStartClean) {
		this.timeStartClean = timeStartClean;
	}

	public Boolean getIsEmpty() {
		return isEmpty;
	}
	public void setIsEmpty(Boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public Boolean getIsFull() {
		return isFull;
	}
	
	public DetailRoom(Boolean isEmpty, Boolean isFull, Boolean isClean, Integer numberRoom, String typeRoom,
			LocalDateTime timeStartRent, LocalDateTime timeStartClean, String nameRent, String nameCLean,
			String timeRent, String timeClean, String idticketbooking) {
		super();
		this.isEmpty = isEmpty;
		this.isFull = isFull;
		this.isClean = isClean;
		this.numberRoom = numberRoom;
		this.typeRoom = typeRoom;
		this.timeStartRent = timeStartRent;
		this.timeStartClean = timeStartClean;
		this.nameRent = nameRent;
		this.nameCLean = nameCLean;
		this.timeRent = timeRent;
		this.timeClean = timeClean;
		this.idticketbooking = idticketbooking;
	}
	public void setIsFull(Boolean isFull) {
		this.isFull = isFull;
	}
	public Boolean getIsClean() {
		return isClean;
	}
	public void setIsClean(Boolean isClean) {
		this.isClean = isClean;
	}
	public Integer getNumberRoom() {
		return numberRoom;
	}
	public void setNumberRoom(Integer numberRoom) {
		this.numberRoom = numberRoom;
	}
	public String getTypeRoom() {
		return typeRoom;
	}
	public void setTypeRoom(String typeRoom) {
		this.typeRoom = typeRoom;
	}
	public LocalDateTime getTimeStartRent() {
		return timeStartRent;
	}
	public void setTimeStartRent(LocalDateTime timeStartRent) {
		this.timeStartRent = timeStartRent;
	}
	public String getNameRent() {
		return nameRent;
	}
	public void setNameRent(String nameRent) {
		this.nameRent = nameRent;
	}
	public String getNameCLean() {
		return nameCLean;
	}
	public void setNameCLean(String nameCLean) {
		this.nameCLean = nameCLean;
	}
	public String getTimeRent() {
		return timeRent;
	}
	public void setTimeRent(String timeRent) {
		this.timeRent = timeRent;
	}
	public String getTimeClean() {
		return timeClean;
	}
	public void setTimeClean(String timeClean) {
		this.timeClean = timeClean;
	}
	public DetailRoom() {
		super();
	}
     
	@Override
	public int hashCode() {
		super.setIdHashCode(numberRoom,nameRent);
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		super.setIdHashCode(numberRoom,nameRent);
		return super.equals(obj);
	}
}
