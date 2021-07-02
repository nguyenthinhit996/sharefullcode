package com.minahotel.sourcebackend.pojo;

import java.io.Serializable;

public class DetailservicesLinkFontEnd extends MinaHoTelPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1783928912963030178L;
	private Detailservices detailservices;
	private Production production;
	
	public Detailservices getDetailservices() {
		return detailservices;
	}
	public void setDetailservices(Detailservices detailservices) {
		this.detailservices = detailservices;
	}
	public Production getProduction() {
		return production;
	}
	public void setProduction(Production production) {
		this.production = production;
	}
	public DetailservicesLinkFontEnd(Detailservices detailservices, Production production) {
		super();
		this.detailservices = detailservices;
		this.production = production;
	}
	public DetailservicesLinkFontEnd(int inital) {
		super();
		detailservices = new Detailservices();
		production = new Production();
	}
	
	public DetailservicesLinkFontEnd() {
		super();
	}
	
	 
}
