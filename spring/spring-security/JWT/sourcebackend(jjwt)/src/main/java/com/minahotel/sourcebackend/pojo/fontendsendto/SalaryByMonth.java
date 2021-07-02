package com.minahotel.sourcebackend.pojo.fontendsendto;

import java.math.BigDecimal;

import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;

public class SalaryByMonth extends MinaHoTelPojo{
	
	private String idStaff;
	private String nameStaff;
	private String role;
	private Double numberWork;
	private BigDecimal salaryMonth;
	private BigDecimal bonus;
	private BigDecimal realSalary;
	
	
	public SalaryByMonth() {
		super();
	}

	public String getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(String idStaff) {
		this.idStaff = idStaff;
	}

	public String getNameStaff() {
		return nameStaff;
	}

	public void setNameStaff(String nameStaff) {
		this.nameStaff = nameStaff;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Double getNumberWork() {
		return numberWork;
	}

	public void setNumberWork(Double numberWork) {
		this.numberWork = numberWork;
	}

	public BigDecimal getSalaryMonth() {
		return salaryMonth;
	}

	public void setSalaryMonth(BigDecimal salaryMonth) {
		this.salaryMonth = salaryMonth;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public BigDecimal getRealSalary() {
		return realSalary;
	}

	public void setRealSalary(BigDecimal realSalary) {
	 
		this.realSalary = realSalary;
	}

	public SalaryByMonth(String idStaff, String nameStaff, String role, Double numberWork, BigDecimal salaryMonth,
			BigDecimal bonus, BigDecimal realSalary) {
		super();
		this.idStaff = idStaff;
		this.nameStaff = nameStaff;
		this.role = role;
		this.numberWork = numberWork;
		this.salaryMonth = salaryMonth;
		this.bonus = bonus;
		this.realSalary = realSalary;
	}
	
	
}
