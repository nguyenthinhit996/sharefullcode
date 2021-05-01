package com.minahotel.sourcebackend.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.pojo.Production;
import com.minahotel.sourcebackend.repository.ProductionRepository;
import com.minahotel.sourcebackend.repository.RoomRepository;

@Service
public class ProductionRepositoryServices implements MinaHotelServices{

	@Autowired
	ProductionRepository productionRepository;
	
	
	@Override
	public List<? extends MinaHoTelPojo> getAll() {
		return (List<Production>) productionRepository.findAll();
	}

	@Override
	public List<? extends MinaHoTelPojo> getObjectById(String... id) {
		return productionRepository.findObjectById(id[0]);
	}

	@Override
	public boolean createObject(MinaHoTelPojo minapojo) {
		try {
			Production objectConvertFromMina = (Production) minapojo;
			LocalDateTime now = LocalDateTime.now();
			objectConvertFromMina.setIdproduction(now.toString());
			productionRepository.save(objectConvertFromMina);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean saveOrUpdate(MinaHoTelPojo minapojo) {
		Production objectConvertFromMina = (Production) minapojo;
		Production result = productionRepository.findObjectByIdOnlyOne(
			 objectConvertFromMina.getIdproduction()).map( x ->{
			 x.setExtention(objectConvertFromMina.getExtention());
			 x.setNameproduct(objectConvertFromMina.getNameproduct());
			 x.setProductrates(objectConvertFromMina.getProductrates());
			 x.setImg(objectConvertFromMina.getImg());
			 x.setType(objectConvertFromMina.getType());
			 x.setStatus(objectConvertFromMina.getStatus());
			return productionRepository.save(x);
		}).orElseGet(()->{
			return productionRepository.save(objectConvertFromMina);
		});
		return result != null ? true : false;
	}

	@Override
	public void deleteObject(MinaHoTelPojo minapojo) {
		Production objectConvertFromMina = (Production) minapojo;
		productionRepository.delete(objectConvertFromMina);
	}

	

}
