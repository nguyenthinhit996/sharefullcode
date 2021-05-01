package com.minahotel.sourcebackend.services;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
import org.springframework.stereotype.Service;

import com.minahotel.sourcebackend.enums.EnumTicketAndRoom;
import com.minahotel.sourcebackend.pojo.Dailyworking;
import com.minahotel.sourcebackend.pojo.Datework;
import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.pojo.Staff;
import com.minahotel.sourcebackend.repository.DailyworkingRepository;
import com.minahotel.sourcebackend.repository.DateworkRepository;
import com.minahotel.sourcebackend.repository.StaffRepository;

@Service
public class DailyworkingRepositoryServices implements MinaHotelServices {

	@Autowired
	DailyworkingRepository dailyworkingRepository;

	public DailyworkingRepositoryServices() {
		super();
	}

	@Override
	public List<? extends MinaHoTelPojo> getAll() {
		return (List<Dailyworking>) dailyworkingRepository.findAll();
	}

	@Autowired
	DateworkRepository dateworkRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Override
	public List<? extends MinaHoTelPojo> getObjectById(String... listParameter) {

		// check if not exist then create day
		LocalDate localDate = LocalDate.parse(listParameter[0]);
		Optional<Datework> datework = dateworkRepository.findObjectByIdOnlyOne(localDate);
		// check date work
		if (datework.isPresent()) {
			// check dailyworkingRepository
			List<Dailyworking> lsDailyworkings = new ArrayList<Dailyworking>();
			List<Object> dsObject = dailyworkingRepository.findObjectByIdDay(localDate);
			if (dsObject != null && dsObject.size() != 0) {

				for (Object in : dsObject) {
					Object[] dsList = (Object[]) in;
					Dailyworking newObj = new Dailyworking();
					Date dd = (Date) dsList[0];
					newObj.setIdtoday(dd);
					newObj.setIdstaffwork(String.valueOf(dsList[1]));
					Time time = (Time) dsList[2];
					newObj.setTimestart(time.toLocalTime());
					Time timeend = (Time) dsList[3];
					newObj.setTimeend(timeend.toLocalTime());
					newObj.setNote(String.valueOf(dsList[4]));
					newObj.setIdstaffmanagement(String.valueOf(dsList[5]));
					newObj.setUsernamestaff(String.valueOf(dsList[6]));
					lsDailyworkings.add(newObj);
					System.out.println(newObj);
				}

				return lsDailyworkings;
			} else {
				// not create User
				// get ALl User only status On
				for (MinaHoTelPojo in : staffRepository.findAll()) {
					Staff staffObject = (Staff) in;
					if (EnumTicketAndRoom.ON.getName().equals(staffObject.getStatus())) {
						// add User into table dailyworking
						if (staffObject.getDatework().compareTo(localDate) <= 0) {
							Dailyworking dailyworking = new Dailyworking();
							dailyworking.setIdstaffmanagement(null);
							Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
							dailyworking.setIdtoday(date);
							dailyworking.setIdstaffwork(staffObject.getIdstaff());
							dailyworking.setNote("");
							dailyworking.setUsernamestaff(staffObject.getUsername());
							dailyworking.setTimestart(LocalTime.now());
							dailyworking.setTimeend(LocalTime.now());
							dailyworkingRepository.save(dailyworking);
							lsDailyworkings.add(dailyworking);
						}
					}
				}
				return lsDailyworkings;
			}
		} else {
			// create date work
			Datework dates = new Datework();
			dates.setIddatework(localDate);
			dates.setListuserhalfday("");
			dates.setListuserworkfullday("");
			dates.setRegulation(1);
			dateworkRepository.save(dates);

			List<Dailyworking> dsDailyworking = new ArrayList<Dailyworking>();
			// create work for staff day
			// get ALl User only status On
			for (MinaHoTelPojo in : staffRepository.findAll()) {
				Staff staffObject = (Staff) in;

				if (EnumTicketAndRoom.ON.getName().equals(staffObject.getStatus())
						&& staffObject.getDatework().compareTo(localDate) <= 0) {
					// add User into table dailyworking
					Dailyworking dailyworking = new Dailyworking();
					dailyworking.setIdstaffmanagement(staffObject.getIdstaff()); // set tam thoi
					Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
					dailyworking.setIdtoday(date);
					dailyworking.setIdstaffwork(staffObject.getIdstaff());
					dailyworking.setNote("1");
					dailyworking.setUsernamestaff(staffObject.getUsername());
					dailyworking.setTimestart(LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
					dailyworking.setTimeend(LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
					dailyworkingRepository.save(dailyworking);
					dsDailyworking.add(dailyworking);
				}
			}
			return dsDailyworking;
		}

		// return (List<Dailyworking>)
		// dailyworkingRepository.findObjectById(listParameter[0], listParameter[1]);
	}

	@Override
	public boolean createObject(MinaHoTelPojo minapojo) {
		try {
			Dailyworking objectConvertFromMina = (Dailyworking) minapojo;
			dailyworkingRepository.save(objectConvertFromMina);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean saveOrUpdate(MinaHoTelPojo minapojo) {
		Dailyworking result = null;
		Dailyworking objectConvertFromMina = (Dailyworking) minapojo;

		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(objectConvertFromMina.getIdtoday());

		Optional<Object> objectResult = dailyworkingRepository.findObjectByIdOnlyOne(modifiedDate,
				objectConvertFromMina.getIdstaffwork());

		if (objectResult.isPresent()) {
			Object[] dsList = (Object[]) objectResult.get();
			Dailyworking newObj = new Dailyworking();
			Date dd = (Date) dsList[0];
			newObj.setIdtoday(dd);
			newObj.setIdstaffwork(String.valueOf(dsList[1]));
			Time time = (Time) dsList[2];
			newObj.setTimestart(time.toLocalTime());
			Time timeend = (Time) dsList[3];
			newObj.setTimeend(timeend.toLocalTime());
			newObj.setNote(String.valueOf(dsList[4]));
			newObj.setIdstaffmanagement(String.valueOf(dsList[5]));
			newObj.setUsernamestaff(String.valueOf(dsList[6]));

			dailyworkingRepository.delete(newObj);
			// --------- set change------
			newObj.setNote(objectConvertFromMina.getNote());
			newObj.setTimestart(objectConvertFromMina.getTimestart());
			newObj.setTimeend(objectConvertFromMina.getTimeend());
			newObj.setIdstaffmanagement(objectConvertFromMina.getIdstaffmanagement());
			result = dailyworkingRepository.save(newObj);
		}

		return result != null ? true : false;

//		Dailyworking result = dailyworkingRepository
//				.findObjectByIdOnlyOne(objectConvertFromMina.getIdtoday(), objectConvertFromMina.getIdstaffwork())
//				.map(x -> {
//					x.setIdstaffmanagement(objectConvertFromMina.getIdstaffmanagement());
//					x.setNote(objectConvertFromMina.getNote());
//					x.setTimeend(objectConvertFromMina.getTimeend());
//					x.setTimestart(objectConvertFromMina.getTimestart());
//					return dailyworkingRepository.save(x);
//				}).orElseGet(() -> {
//					return dailyworkingRepository.save(objectConvertFromMina);
//				});
//		
//		return true;
	}
	
	public void autotime() {
 
		List<Object> objectResult = dailyworkingRepository.queryFindObjectByIdAll();

		for(int i=0;i<objectResult.size();i++) {
			Object[] dsList = (Object[]) objectResult.get(i);
			Dailyworking newObj = new Dailyworking();
			Date dd = (Date) dsList[0];
			newObj.setIdtoday(dd);
			newObj.setIdstaffwork(String.valueOf(dsList[1]));
			Time time = (Time) dsList[2];
			newObj.setTimestart(time.toLocalTime());
			Time timeend = (Time) dsList[3];
			newObj.setTimeend(timeend.toLocalTime());
			newObj.setNote(String.valueOf(dsList[4]));
			newObj.setIdstaffmanagement(String.valueOf(dsList[5]));
			newObj.setUsernamestaff(String.valueOf(dsList[6]));

			dailyworkingRepository.delete(newObj);
			
			// --------- set change------
			String[] times = getTime();
			LocalTime am = LocalTime.parse(times[0]);
			LocalTime pm = LocalTime.parse(times[1]);
			
			newObj.setTimestart(am);
			newObj.setTimeend(pm); 
			dailyworkingRepository.save(newObj);
		}

	}
	
	String[] getTime() {
		String[] news = new String[2];
		
		Random rand = new Random(); 		
		int random = rand.nextInt((11 - 4) + 1) + 4;
 
		if(random <= 9) {
			 news[0] =  "0"+ random  + ":00";
		}else {
			news[0] =   random  + ":00";
		}
		int randompm = rand.nextInt((22 - 13) + 1) + 13;
		
		 news[1] =  randompm +":00";
		 return news;
	}

	@Override
	public void deleteObject(MinaHoTelPojo minapojo) {
		Dailyworking objectConvertFromMina = (Dailyworking) minapojo;
		dailyworkingRepository.delete(objectConvertFromMina);
	}

}
