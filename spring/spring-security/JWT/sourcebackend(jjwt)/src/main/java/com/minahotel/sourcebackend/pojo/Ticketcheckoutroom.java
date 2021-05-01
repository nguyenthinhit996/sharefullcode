package com.minahotel.sourcebackend.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticketcheckoutroom extends MinaHoTelPojo{

	@Id
	private String idticketcheckoutroom;
	private String idticketbooking;
	private LocalDateTime timeendrent;
	private String idstaffreceptionsupport;
	private int numberroomrent;
	private BigDecimal sumaryratesandservices;
	private BigDecimal raterentroom;
	private BigDecimal rateservices;
	private BigDecimal roomsubcharge;
	private BigDecimal roomdamaged;
	private String status; // clean off
	private String timerent;
	
	
	
	public String getTimeRent() {
		return timerent;
	}



	public void setTimeRent(String timeRent) {
		this.timerent = timeRent;
	}



	public Ticketcheckoutroom() {
		super();
	}

	  

	public Ticketcheckoutroom(String idticketcheckoutroom, String idticketbooking, LocalDateTime timeendrent,
			String idstaffreceptionsupport, int numberroomrent, BigDecimal sumaryratesandservices, BigDecimal rateRent,
			BigDecimal rateservices, BigDecimal roomSubCharge, BigDecimal roomDamaged, String status,
			 String timeRent) {
		super();
		this.idticketcheckoutroom = idticketcheckoutroom;
		this.idticketbooking = idticketbooking;
		this.timeendrent = timeendrent;
		this.idstaffreceptionsupport = idstaffreceptionsupport;
		this.numberroomrent = numberroomrent;
		this.sumaryratesandservices = sumaryratesandservices;
		this.raterentroom = rateRent;
		this.rateservices = rateservices;
		this.roomsubcharge = roomSubCharge;
		this.roomdamaged = roomDamaged;
		this.status = status;
		this.timerent = timeRent;
	}

	public BigDecimal getRaterentroom() {
		return raterentroom;
	}



	public void setRaterentroom(BigDecimal raterentroom) {
		this.raterentroom = raterentroom;
	}



	public BigDecimal getRoomsubcharge() {
		return roomsubcharge;
	}



	public void setRoomsubcharge(BigDecimal roomsubcharge) {
		this.roomsubcharge = roomsubcharge;
	}



	public BigDecimal getRoomdamaged() {
		return roomdamaged;
	}



	public void setRoomdamaged(BigDecimal roomdamaged) {
		this.roomdamaged = roomdamaged;
	}



	public String getTimerent() {
		return timerent;
	}



	public void setTimerent(String timerent) {
		this.timerent = timerent;
	}



	public BigDecimal getRateservices() {
		return rateservices;
	}

	public void setRateservices(BigDecimal rateservices) {
		this.rateservices = rateservices;
	}

	public BigDecimal getRoomSubCharge() {
		return roomsubcharge;
	}

	public void setRoomSubCharge(BigDecimal roomSubCharge) {
		this.roomsubcharge = roomSubCharge;
	}

	public BigDecimal getRoomDamaged() {
		return roomdamaged;
	}

	public void setRoomDamaged(BigDecimal roomDamaged) {
		this.roomdamaged = roomDamaged;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getIdticketcheckoutroom() {
		return idticketcheckoutroom;
	}

	public void setIdticketcheckoutroom(String idticketcheckoutroom) {
		this.idticketcheckoutroom = idticketcheckoutroom;
	}

	public String getIdticketbooking() {
		return idticketbooking;
	}

	public void setIdticketbooking(String idticketbooking) {
		this.idticketbooking = idticketbooking;
	}

	public LocalDateTime getTimeendrent() {
		return timeendrent;
	}

	public void setTimeendrent(LocalDateTime timeendrent) {
		this.timeendrent = timeendrent;
	}

	public String getIdstaffreceptionsupport() {
		return idstaffreceptionsupport;
	}

	public void setIdstaffreceptionsupport(String idstaffreceptionsupport) {
		this.idstaffreceptionsupport = idstaffreceptionsupport;
	}

	public int getNumberroomrent() {
		return numberroomrent;
	}

	public void setNumberroomrent(int numberroomrent) {
		this.numberroomrent = numberroomrent;
	}

	public BigDecimal getSumaryratesandservices() {
		return sumaryratesandservices;
	}

	public void setSumaryratesandservices(BigDecimal sumaryratesandservices) {
		this.sumaryratesandservices = sumaryratesandservices;
	}
	
	@Override
	public int hashCode() {
		super.setIdHashCode(idticketcheckoutroom);
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		super.setIdHashCode(idticketcheckoutroom);
		return super.equals(obj);
	}
	
}
