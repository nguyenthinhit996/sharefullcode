package com.minahotel.sourcebackend.pojo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Production extends MinaHoTelPojo {

	@Id
	private String idproduction;
	private String nameproduct;
	private String extention;
	private BigDecimal productrates;
	private String img;
	private String type;
	private String status;

	public Production() {
		super();
	}


	public Production(String idproduction, String nameproduct, String extention, BigDecimal productrates, String img,
			String type, String status) {
		super();
		this.idproduction = idproduction;
		this.nameproduct = nameproduct;
		this.extention = extention;
		this.productrates = productrates;
		this.img = img;
		this.type = type;
		this.status = status;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public String getIdproduction() {
		return idproduction;
	}

	public void setIdproduction(String idproduction) {
		this.idproduction = idproduction;
	}

	public String getNameproduct() {
		return nameproduct;
	}

	public void setNameproduct(String nameproduct) {
		this.nameproduct = nameproduct;
	}

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public BigDecimal getProductrates() {
		return productrates;
	}

	public void setProductrates(BigDecimal productrates) {
		this.productrates = productrates;
	}

	@Override
	public int hashCode() {
		super.setIdHashCode(idproduction);
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		super.setIdHashCode(idproduction);
		return super.equals(obj);
	}
}
