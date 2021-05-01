package com.minahotel.sourcebackend.pojo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Typeofroom extends MinaHoTelPojo{
	
	@Id
	private String nametypeofroom;
	private BigDecimal roomrateshours;
	private BigDecimal roomratesdates;
	private int numberinroom;
	private BigDecimal roomratescharge;
	
	public Typeofroom() {
		super();
	}

	public Typeofroom(String nametypeofroom, BigDecimal roomrateshours, BigDecimal roomratesdates, int numberinroom,
			BigDecimal roomratescharge) {
		super();
		this.nametypeofroom = nametypeofroom;
		this.roomrateshours = roomrateshours;
		this.roomratesdates = roomratesdates;
		this.numberinroom = numberinroom;
		this.roomratescharge = roomratescharge;
	}

	public String getNametypeofroom() {
		return nametypeofroom;
	}

	public void setNametypeofroom(String nametypeofroom) {
		this.nametypeofroom = nametypeofroom;
	}

	public BigDecimal getRoomrateshours() {
		return roomrateshours;
	}

	public void setRoomrateshours(BigDecimal roomrateshours) {
		this.roomrateshours = roomrateshours;
	}

	public BigDecimal getRoomratesdates() {
		return roomratesdates;
	}

	public void setRoomratesdates(BigDecimal roomratesdates) {
		this.roomratesdates = roomratesdates;
	}

	public int getNumberinroom() {
		return numberinroom;
	}

	public void setNumberinroom(int numberinroom) {
		this.numberinroom = numberinroom;
	}

	public BigDecimal getRoomratescharge() {
		return roomratescharge;
	}

	public void setRoomratescharge(BigDecimal roomratescharge) {
		this.roomratescharge = roomratescharge;
	}
	
	@Override
	public int hashCode() {
		super.setIdHashCode(nametypeofroom);
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		super.setIdHashCode(nametypeofroom);
		return super.equals(obj);
	}
}
