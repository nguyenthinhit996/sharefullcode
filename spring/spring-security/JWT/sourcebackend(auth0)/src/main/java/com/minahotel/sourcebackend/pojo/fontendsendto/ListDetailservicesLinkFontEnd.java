package com.minahotel.sourcebackend.pojo.fontendsendto;

import java.io.Serializable;
import java.util.List;

import com.minahotel.sourcebackend.pojo.DetailservicesLinkFontEnd;
import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;

public class ListDetailservicesLinkFontEnd extends MinaHoTelPojo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2607729210363047894L;
	
	private List<DetailservicesLinkFontEnd> dsDetailservicesLinkFontEnd;

	public List<DetailservicesLinkFontEnd> getDsDetailservicesLinkFontEnd() {
		return dsDetailservicesLinkFontEnd;
	}

	public void setDsDetailservicesLinkFontEnd(List<DetailservicesLinkFontEnd> dsDetailservicesLinkFontEnd) {
		this.dsDetailservicesLinkFontEnd = dsDetailservicesLinkFontEnd;
	}

	public ListDetailservicesLinkFontEnd(List<DetailservicesLinkFontEnd> dsDetailservicesLinkFontEnd) {
		super();
		this.dsDetailservicesLinkFontEnd = dsDetailservicesLinkFontEnd;
	}

	public ListDetailservicesLinkFontEnd() {
		super();
	}
	
	
}
