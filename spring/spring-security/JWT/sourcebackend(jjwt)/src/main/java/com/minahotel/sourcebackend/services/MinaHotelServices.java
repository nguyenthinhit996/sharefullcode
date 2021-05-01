package com.minahotel.sourcebackend.services;

import java.util.List;

import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;

public interface MinaHotelServices {

	public List<? extends MinaHoTelPojo> getAll();

	public List<? extends MinaHoTelPojo> getObjectById(String ...id) ;
	
	public boolean createObject(MinaHoTelPojo minapojo);
	
	public boolean saveOrUpdate(MinaHoTelPojo minapojo);
	
	public void deleteObject(MinaHoTelPojo minapojo);
	
}
