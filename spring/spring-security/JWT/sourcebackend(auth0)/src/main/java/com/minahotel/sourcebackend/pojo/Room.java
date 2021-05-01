package com.minahotel.sourcebackend.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room extends MinaHoTelPojo{

	@Id
	private int idroom;
	private String nametyperoom;
	private String status;
	public int getIdroom() {
		return idroom;
	}
	public void setIdroom(int idroom) {
		this.idroom = idroom;
	}
	public String getNametyperoom() {
		return nametyperoom;
	}
	public void setNametyperoom(String nametyperoom) {
		this.nametyperoom = nametyperoom;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Room(int idroom, String nametyperoom, String status) {
		super();
		this.idroom = idroom;
		this.nametyperoom = nametyperoom;
		this.status = status;
	}
	
	public Room() {
		super();
	}
	
	@Override
	public int hashCode() {
		super.setIdHashCode(idroom);
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		super.setIdHashCode(idroom);
		return super.equals(obj);
	}
}
