package com.minahotel.sourcebackend.pojo;

public class ChangePassPojo {

	private String idStaff;
	private String passwordOld;
	private String passwordNew;
	public String getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(String idStaff) {
		this.idStaff = idStaff;
	}
	public String getPasswordOld() {
		return passwordOld;
	}
	public void setPasswordOld(String passwordOld) {
		this.passwordOld = passwordOld;
	}
	public String getPasswordNew() {
		return passwordNew;
	}
	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}
	public ChangePassPojo(String idStaff, String passwordOld, String passwordNew) {
		super();
		this.idStaff = idStaff;
		this.passwordOld = passwordOld;
		this.passwordNew = passwordNew;
	}
	public ChangePassPojo() {
		super();
	}
	
}
