package com.minahotel.sourcebackend.pojo.fontendsendto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.pojo.Ticketbooking;


public class TicketcheckoutroomFontEnd extends MinaHoTelPojo{

	private String idticketcheckoutroom;
	private String idticketbooking;
	private LocalDateTime timeendrent;
	private String idstaffreceptionsupport;
	private int numberroomrent;
	private BigDecimal sumaryratesandservices;
	private BigDecimal rateRent;
	private BigDecimal rateservices;
	private BigDecimal roomSubCharge;
	private BigDecimal roomDamaged;
	private String status; //checking clean off
	private Ticketbooking ticketbooking;
	private String timeRent;
	private BigDecimal rateSubChargeInRoom;
	private int maxRentNumberInRoom;
	
	private String  listDamaged;
	
	public TicketcheckoutroomFontEnd(String idticketcheckoutroom, String idticketbooking, LocalDateTime timeendrent,
			String idstaffreceptionsupport, int numberroomrent, BigDecimal sumaryratesandservices, BigDecimal rateRent,
			BigDecimal rateservices, BigDecimal roomSubCharge, BigDecimal roomDamaged, String status,
			Ticketbooking ticketbooking, String timeRent, BigDecimal rateSubChargeInRoom, int maxRentNumberInRoom,
			String listDamaged) {
		super();
		this.idticketcheckoutroom = idticketcheckoutroom;
		this.idticketbooking = idticketbooking;
		this.timeendrent = timeendrent;
		this.idstaffreceptionsupport = idstaffreceptionsupport;
		this.numberroomrent = numberroomrent;
		this.sumaryratesandservices = sumaryratesandservices;
		this.rateRent = rateRent;
		this.rateservices = rateservices;
		this.roomSubCharge = roomSubCharge;
		this.roomDamaged = roomDamaged;
		this.status = status;
		this.ticketbooking = ticketbooking;
		this.timeRent = timeRent;
		this.rateSubChargeInRoom = rateSubChargeInRoom;
		this.maxRentNumberInRoom = maxRentNumberInRoom;
		this.listDamaged = listDamaged;
	}



	public String getListDamaged() {
		return listDamaged;
	}



	public void setListDamaged(String listDamaged) {
		this.listDamaged = listDamaged;
	}



	public int getMaxRentNumberInRoom() {
		return maxRentNumberInRoom;
	}



	public void setMaxRentNumberInRoom(int maxRentNumberInRoom) {
		this.maxRentNumberInRoom = maxRentNumberInRoom;
	}



	public BigDecimal getRateSubChargeInRoom() {
		return rateSubChargeInRoom;
	}



	public void setRateSubChargeInRoom(BigDecimal rateSubChargeInRoom) {
		this.rateSubChargeInRoom = rateSubChargeInRoom;
	}



	public String getTimeRent() {
		return timeRent;
	}



	public void setTimeRent(String timeRent) {
		this.timeRent = timeRent;
	}



	public TicketcheckoutroomFontEnd() {
		super();
	}

	 

	public Ticketbooking getTicketbooking() {
		return ticketbooking;
	}



	public void setTicketbooking(Ticketbooking ticketbooking) {
		this.ticketbooking = ticketbooking;
	}



	public BigDecimal getRateRent() {
		return rateRent;
	}

	public void setRateRent(BigDecimal rateRent) {
		this.rateRent = rateRent;
	}


	public BigDecimal getRateservices() {
		return rateservices;
	}

	public void setRateservices(BigDecimal rateservices) {
		this.rateservices = rateservices;
	}

	public BigDecimal getRoomSubCharge() {
		return roomSubCharge;
	}

	public void setRoomSubCharge(BigDecimal roomSubCharge) {
		this.roomSubCharge = roomSubCharge;
	}

	public BigDecimal getRoomDamaged() {
		return roomDamaged;
	}

	public void setRoomDamaged(BigDecimal roomDamaged) {
		this.roomDamaged = roomDamaged;
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
