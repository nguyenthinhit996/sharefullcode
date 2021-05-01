package com.minahotel.sourcebackend.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.pojo.TypeOfRoomAll;
import com.minahotel.sourcebackend.pojo.Typeofroom;
import com.minahotel.sourcebackend.repository.TypeofroomRepository;

@Service
public class TypeofroomRepositoryServies implements MinaHotelServices{

	@Autowired
	TypeofroomRepository typeofroomRepository;
	
	@Override
	public List<? extends MinaHoTelPojo> getAll() {
		return (List<Typeofroom>) typeofroomRepository.findAll();
	}

	@Override
	public List<? extends MinaHoTelPojo> getObjectById(String... id) {
		return (List<Typeofroom>) typeofroomRepository.findObjectById(id[0]);
	}

	@Override
	public boolean createObject(MinaHoTelPojo minapojo) {
		try {
			Typeofroom objectConvertFromMina = (Typeofroom) minapojo;
			typeofroomRepository.save(objectConvertFromMina);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean saveOrUpdate(MinaHoTelPojo minapojo) {
		Typeofroom objectConvertFromMina = (Typeofroom) minapojo;
		Typeofroom result = typeofroomRepository.findObjectByIdOnlyOne(
				objectConvertFromMina.getNametypeofroom()).map( x ->{
			 x.setNumberinroom(objectConvertFromMina.getNumberinroom());
			 x.setRoomratescharge(objectConvertFromMina.getRoomratescharge());
			 x.setRoomratesdates(objectConvertFromMina.getRoomratesdates());
			 x.setRoomrateshours(objectConvertFromMina.getRoomrateshours());
			return typeofroomRepository.save(x);
		}).orElseGet(()->{
			return typeofroomRepository.save(objectConvertFromMina);
		});
		return result != null ? true : false;
	}
	

	public boolean saveOrUpdateAll(TypeOfRoomAll minapojo) {
		 try {
			 Optional<Typeofroom> opSingle = typeofroomRepository.findObjectByIdOnlyOne("single");
			 Typeofroom single = opSingle.get();
			 single.setNumberinroom(Integer.valueOf(minapojo.getSingleNumberInRoom()));
			 single.setRoomratescharge(BigDecimal.valueOf(Double.valueOf(minapojo.getSingleSubcharged())));
			 single.setRoomratesdates(BigDecimal.valueOf(Double.valueOf(minapojo.getSingleRoomRatesDay())));
			 single.setRoomrateshours(BigDecimal.valueOf(Double.valueOf(minapojo.getSingleRoomRatesHours())));
			 typeofroomRepository.save(single);
			 
			 Optional<Typeofroom> opDouble = typeofroomRepository.findObjectByIdOnlyOne("double");
			 Typeofroom doubles= opDouble.get();
			 doubles.setNumberinroom(Integer.valueOf(minapojo.getDoubleNumberInRoom()));
			 doubles.setRoomratescharge(BigDecimal.valueOf(Double.valueOf(minapojo.getDoubleSubcharged())));
			 doubles.setRoomratesdates(BigDecimal.valueOf(Double.valueOf(minapojo.getDoubleRoomRatesDay())));
			 doubles.setRoomrateshours(BigDecimal.valueOf(Double.valueOf(minapojo.getDoubleRoomRatesHours())));
			 typeofroomRepository.save(doubles);
			 
			 Optional<Typeofroom> opVip = typeofroomRepository.findObjectByIdOnlyOne("vip");
			 Typeofroom vip= opVip.get();
			 vip.setNumberinroom(Integer.valueOf(minapojo.getVipNumberInRoom()));
			 vip.setRoomratescharge(BigDecimal.valueOf(Double.valueOf(minapojo.getVipSubcharged())));
			 vip.setRoomratesdates(BigDecimal.valueOf(Double.valueOf(minapojo.getVipRoomRatesDay())));
			 vip.setRoomrateshours(BigDecimal.valueOf(Double.valueOf(minapojo.getVipRoomRatesHours())));
			 typeofroomRepository.save(vip);
			 
		 }catch(Exception x) {
			 return false;
		 }
		 return true;
	}

	@Override
	public void deleteObject(MinaHoTelPojo minapojo) {
		// TODO Auto-generated method stub
		
	}

}
