package com.minahotel.sourcebackend.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;



public class Revenue extends MinaHoTelPojo{
	
	private String iddatework;
	private BigDecimal singleRoom;
	private BigDecimal doubleRoom;
	private BigDecimal vipRoom;
	
	public Revenue() {
		super();
		singleRoom=BigDecimal.ZERO;
		doubleRoom=BigDecimal.ZERO;
		vipRoom=BigDecimal.ZERO;
	}

	public Revenue(String iddatework, BigDecimal singleRoom, BigDecimal doubleRoom, BigDecimal vipRoom) {
		super();
		this.iddatework = iddatework;
		this.singleRoom = singleRoom;
		this.doubleRoom = doubleRoom;
		this.vipRoom = vipRoom;
	}

	public String getIddatework() {
		return iddatework;
	}

	public void setIddatework(String iddatework) {
		this.iddatework = iddatework;
	}

	public BigDecimal getSingleRoom() {
		return singleRoom;
	}

	public void setSingleRoom(BigDecimal singleRoom) {
		this.singleRoom = singleRoom;
	}

	public BigDecimal getDoubleRoom() {
		return doubleRoom;
	}

	public void setDoubleRoom(BigDecimal doubleRoom) {
		this.doubleRoom = doubleRoom;
	}

	public BigDecimal getVipRoom() {
		return vipRoom;
	}

	public void setVipRoom(BigDecimal vipRoom) {
		this.vipRoom = vipRoom;
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
