package com.minahotel.sourcebackend.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(Detailservices.class)
public class Detailservices extends MinaHoTelPojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9042999124374829201L;
	@Id
	private String idticketbooking;
	@Id
	private String idproduct;
	private String idstaffservicesrepo;
	private int amount;
	private LocalDateTime startrent;
	private LocalDateTime endrent;
	private String status;  // prepare-> shipping (send to user service) -> Todo(userservices doing) -> Done
	private BigDecimal sumaryservices;

	public Detailservices() {
		super();
	}

	public Detailservices(String idticketbooking, String idproduct, String idstaffservicesrepo, int amount,
			LocalDateTime startrent, LocalDateTime endrent, String status, BigDecimal sumaryservices) {
		super();
		this.idticketbooking = idticketbooking;
		this.idproduct = idproduct;
		this.idstaffservicesrepo = idstaffservicesrepo;
		this.amount = amount;
		this.startrent = startrent;
		this.endrent = endrent;
		this.status = status;
		this.sumaryservices = sumaryservices;
	}

	public String getIdticketbooking() {
		return idticketbooking;
	}

	public void setIdticketbooking(String idticketbooking) {
		this.idticketbooking = idticketbooking;
	}

	public String getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(String idproduct) {
		this.idproduct = idproduct;
	}

	public String getIdstaffservicesrepo() {
		return idstaffservicesrepo;
	}

	public void setIdstaffservicesrepo(String idstaffservicesrepo) {
		this.idstaffservicesrepo = idstaffservicesrepo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDateTime getStartrent() {
		return startrent;
	}

	public void setStartrent(LocalDateTime startrent) {
		this.startrent = startrent;
	}

	public LocalDateTime getEndrent() {
		return endrent;
	}

	public void setEndrent(LocalDateTime endrent) {
		this.endrent = endrent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getSumaryservices() {
		return sumaryservices;
	}

	public void setSumaryservices(BigDecimal sumaryservices) {
		this.sumaryservices = sumaryservices;
	}

	@Override
	public int hashCode() {
		super.setIdHashCode(idticketbooking, idproduct);
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		super.setIdHashCode(idticketbooking, idproduct);
		return super.equals(obj);
	}
}
