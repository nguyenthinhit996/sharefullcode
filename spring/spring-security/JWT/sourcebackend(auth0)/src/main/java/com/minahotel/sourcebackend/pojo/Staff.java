package com.minahotel.sourcebackend.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Staff extends MinaHoTelPojo{

	@Id
	private String idstaff;
	private String username;
	private String pass;
	private String role;
	private LocalDate datework;
	private BigDecimal salarymonth;
	private BigDecimal bonussalary;
	private String status;
	
 

	public Staff(String idstaff, String username, String pass, String role, LocalDate datework, BigDecimal salarymonth,
			BigDecimal bonussalary, String status) {
		super();
		this.idstaff = idstaff;
		this.username = username;
		this.pass = pass;
		this.role = role;
		this.datework = datework;
		this.salarymonth = salarymonth;
		this.bonussalary = bonussalary;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Staff() {
		super();
	}

	public String getIdstaff() {
		return idstaff;
	}

	public void setIdstaff(String idstaff) {
		this.idstaff = idstaff;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDate getDatework() {
		return datework;
	}

	public void setDatework(LocalDate datework) {
		this.datework = datework;
	}

	public BigDecimal getSalarymonth() {
		return salarymonth;
	}

	public void setSalarymonth(BigDecimal salarymonth) {
		this.salarymonth = salarymonth;
	}

	public BigDecimal getBonussalary() {
		return bonussalary;
	}

	public void setBonussalary(BigDecimal bonussalary) {
		this.bonussalary = bonussalary;
	}
	
	@Override
	public int hashCode() {
		super.setIdHashCode(idstaff);
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		super.setIdHashCode(idstaff);
		return super.equals(obj);
	}
	
	
}
