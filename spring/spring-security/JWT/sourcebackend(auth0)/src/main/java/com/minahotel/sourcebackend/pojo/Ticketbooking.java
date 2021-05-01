package com.minahotel.sourcebackend.pojo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticketbooking extends MinaHoTelPojo{

	@Id
	private String idticketbooking;
	private String iduserrentroom;
	private String usernamerentroom;
	private LocalDateTime timestamprent;
	private String idstaffreception;
	private int numberroom;
	private int numberinroom;
	private String status; // on off
	
	public Ticketbooking(String idticketbooking, String iduserrentroom, String usernamerentroom,
			LocalDateTime timestamprent, String idstaffreception, int numberroom, int numberinroom, String status) {
		super();
		this.idticketbooking = idticketbooking;
		this.iduserrentroom = iduserrentroom;
		this.usernamerentroom = usernamerentroom;
		this.timestamprent = timestamprent;
		this.idstaffreception = idstaffreception;
		this.numberroom = numberroom;
		this.numberinroom = numberinroom;
		this.status = status;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Ticketbooking() {
		super();
	}

	public String getIdticketbooking() {
		return idticketbooking;
	}



	public void setIdticketbooking(String idticketbooking) {
		this.idticketbooking = idticketbooking;
	}



	public String getIduserrentroom() {
		return iduserrentroom;
	}



	public void setIduserrentroom(String iduserrentroom) {
		this.iduserrentroom = iduserrentroom;
	}



	public String getUsernamerentroom() {
		return usernamerentroom;
	}



	public void setUsernamerentroom(String usernamerentroom) {
		this.usernamerentroom = usernamerentroom;
	}



	public LocalDateTime getTimestamprent() {
		return timestamprent;
	}



	public void setTimestamprent(LocalDateTime timestamprent) {
		this.timestamprent = timestamprent;
	}



	public String getIdstaffreception() {
		return idstaffreception;
	}



	public void setIdstaffreception(String idstaffreception) {
		this.idstaffreception = idstaffreception;
	}



	public int getNumberroom() {
		return numberroom;
	}



	public void setNumberroom(int numberroom) {
		this.numberroom = numberroom;
	}



	public int getNumberinroom() {
		return numberinroom;
	}



	public void setNumberinroom(int numberinroom) {
		this.numberinroom = numberinroom;
	}



	@Override
	public int hashCode() {
		super.setIdHashCode(idticketbooking);
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		super.setIdHashCode(idticketbooking);
		return super.equals(obj);
	}
}
