package com.minahotel.sourcebackend.pojo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Datework extends MinaHoTelPojo{
	
	@Id
	private LocalDate iddatework;
	private String listuserworkfullday;
	private String listuserhalfday;
	// Ngày thường: 1 Thứ 7,CN: 1.5 Lương
	private int regulation;
	
	public Datework() {
		super();
	}

	public Datework(LocalDate iddatework, String listuserworkfullday, String listuserhalfday, int regulation) {
		super();
		this.iddatework = iddatework;
		this.listuserworkfullday = listuserworkfullday;
		this.listuserhalfday = listuserhalfday;
		this.regulation = regulation;
	}

	public LocalDate getIddatework() {
		return iddatework;
	}

	public void setIddatework(LocalDate iddatework) {
		this.iddatework = iddatework;
	}

	public String getListuserworkfullday() {
		return listuserworkfullday;
	}

	public void setListuserworkfullday(String listuserworkfullday) {
		this.listuserworkfullday = listuserworkfullday;
	}

	public String getListuserhalfday() {
		return listuserhalfday;
	}

	public void setListuserhalfday(String listuserhalfday) {
		this.listuserhalfday = listuserhalfday;
	}

	public int getRegulation() {
		return regulation;
	}

	public void setRegulation(int regulation) {
		this.regulation = regulation;
	}
	
	@Override
	public int hashCode() {
		super.setIdHashCode(this.iddatework);
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		super.setIdHashCode(iddatework);
		return super.equals(obj);
	}
	
}
