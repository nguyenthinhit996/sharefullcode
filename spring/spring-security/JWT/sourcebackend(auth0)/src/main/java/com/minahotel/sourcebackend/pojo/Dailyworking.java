package com.minahotel.sourcebackend.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity 
@IdClass(Dailyworking.class) 
public class Dailyworking extends MinaHoTelPojo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7364467469594740507L;

	@Id
	private Date idtoday;
	
	@Id
	private String idstaffwork;
	
	private LocalTime timestart;
	private LocalTime timeend;
	private String note;
	private String idstaffmanagement;
	private String usernamestaff;
	

	public Dailyworking(Date idtoday, String idstaffwork, LocalTime timestart, LocalTime timeend, String note,
			String idstaffmanagement, String usernamework) {
		super();
		this.idtoday = idtoday;
		this.idstaffwork = idstaffwork;
		this.timestart = timestart;
		this.timeend = timeend;
		this.note = note;
		this.idstaffmanagement = idstaffmanagement;
		this.usernamestaff = usernamework;
	}

	
	
	public String getUsernamestaff() {
		return usernamestaff;
	}



	public void setUsernamestaff(String usernamestaff) {
		this.usernamestaff = usernamestaff;
	}



	public String getUsernamework() {
		return usernamestaff;
	}

	public void setUsernamework(String usernamework) {
		this.usernamestaff = usernamework;
	}

	public Dailyworking() {
		super();
	}

	public Date getIdtoday() {
		return idtoday;
	}

	public void setIdtoday(Date idtoday) {
		this.idtoday = idtoday;
	}

	public String getIdstaffwork() {
		return idstaffwork;
	}

	public void setIdstaffwork(String idstaffwork) {
		this.idstaffwork = idstaffwork;
	}

	public LocalTime getTimestart() {
		return timestart;
	}

	public void setTimestart(LocalTime timestart) {
		this.timestart = timestart;
	}

	public LocalTime getTimeend() {
		return timeend;
	}

	public void setTimeend(LocalTime timeend) {
		this.timeend = timeend;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getIdstaffmanagement() {
		return idstaffmanagement;
	}

	public void setIdstaffmanagement(String idstaffmanagement) {
		this.idstaffmanagement = idstaffmanagement;
	}
	
	@Override
	public int hashCode() {
		super.setIdHashCode(idtoday,idstaffwork);
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		super.setIdHashCode(idtoday,idstaffwork);
		return super.equals(obj);
	}
	
}
