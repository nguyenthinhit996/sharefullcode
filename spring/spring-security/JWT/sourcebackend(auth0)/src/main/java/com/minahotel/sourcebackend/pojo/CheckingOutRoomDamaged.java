package com.minahotel.sourcebackend.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 

@Entity
@Table(name = "checkingoutroomdamaged")
public class CheckingOutRoomDamaged extends MinaHoTelPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9149967809016377966L;
	
	
	@Id
	private String idcheckingoutroomdamaded;
	private String idcheckoutroom;
	private String idticketbooking;
	private String listproductdamaded;
	private String idstaffchecking;
	private BigDecimal sumaryindemnify;
	private String status;
	
	 
	
	public CheckingOutRoomDamaged() {
		super();
	}

	public CheckingOutRoomDamaged(String idcheckingoutroomdamaded, String idcheckoutroom, String idticketbooking,
			String listproductdamaded, String idstaffchecking, BigDecimal sumaryindemnify, String status) {
		super();
		this.idcheckingoutroomdamaded = idcheckingoutroomdamaded;
		this.idcheckoutroom = idcheckoutroom;
		this.idticketbooking = idticketbooking;
		this.listproductdamaded = listproductdamaded;
		this.idstaffchecking = idstaffchecking;
		this.sumaryindemnify = sumaryindemnify;
		this.status = status;
	}

	public String getIdcheckingoutroomdamaded() {
		return idcheckingoutroomdamaded;
	}

	public void setIdcheckingoutroomdamaded(String idcheckingoutroomdamaded) {
		this.idcheckingoutroomdamaded = idcheckingoutroomdamaded;
	}

	public String getIdcheckoutroom() {
		return idcheckoutroom;
	}

	public void setIdcheckoutroom(String idcheckoutroom) {
		this.idcheckoutroom = idcheckoutroom;
	}

	public String getIdticketbooking() {
		return idticketbooking;
	}

	public void setIdticketbooking(String idticketbooking) {
		this.idticketbooking = idticketbooking;
	}

	public String getListproductdamaded() {
		return listproductdamaded;
	}

	public void setListproductdamaded(String listproductdamaded) {
		this.listproductdamaded = listproductdamaded;
	}

	public String getIdstaffchecking() {
		return idstaffchecking;
	}

	public void setIdstaffchecking(String idstaffchecking) {
		this.idstaffchecking = idstaffchecking;
	}

	public BigDecimal getSumaryindemnify() {
		return sumaryindemnify;
	}

	public void setSumaryindemnify(BigDecimal sumaryindemnify) {
		this.sumaryindemnify = sumaryindemnify;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		super.setIdHashCode(idcheckingoutroomdamaded);
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		super.setIdHashCode(idcheckingoutroomdamaded);
		return super.equals(obj);
	}
}
