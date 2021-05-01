package com.minahotel.sourcebackend.services;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minahotel.sourcebackend.enums.EnumTicketAndRoom;
import com.minahotel.sourcebackend.pojo.Dailyworking;
import com.minahotel.sourcebackend.pojo.Datework;
import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.pojo.Staff;
import com.minahotel.sourcebackend.pojo.fontendsendto.SalaryByMonth;
import com.minahotel.sourcebackend.repository.DailyworkingRepository;
import com.minahotel.sourcebackend.repository.DateworkRepository;
import com.minahotel.sourcebackend.repository.StaffRepository;

@Service
public class DateworkRepositoryServices implements MinaHotelServices {

	@Autowired
	DateworkRepository dateworkRepository;

	@Override
	public List<? extends MinaHoTelPojo> getAll() {
		return (List<Datework>) dateworkRepository.findAll();
	}

	@Override
	public List<? extends MinaHoTelPojo> getObjectById(String... id) {
		return dateworkRepository.findObjectById(id[0]);
	}

	@Override
	public boolean createObject(MinaHoTelPojo minapojo) {
		try {
			Datework objectConvertFromMina = (Datework) minapojo;
			dateworkRepository.save(objectConvertFromMina);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean saveOrUpdate(MinaHoTelPojo minapojo) {
		Datework objectConvertFromMina = (Datework) minapojo;
		Datework result = dateworkRepository.findObjectByIdOnlyOne(objectConvertFromMina.getIddatework()).map(x -> {
			x.setListuserhalfday(objectConvertFromMina.getListuserhalfday());
			x.setListuserworkfullday(objectConvertFromMina.getListuserworkfullday());
			x.setIddatework(null);
			return dateworkRepository.save(x);
		}).orElseGet(() -> {
			return dateworkRepository.save(objectConvertFromMina);
		});
		return result != null ? true : false;
	}

	@Override
	public void deleteObject(MinaHoTelPojo minapojo) {
		Datework objectConvertFromMina = (Datework) minapojo;
		dateworkRepository.delete(objectConvertFromMina);
	}

	@Autowired
	DailyworkingRepository dailyworkingRepository;

	@Autowired
	private StaffRepository staffRepository;

	public List<? extends MinaHoTelPojo> getSalaryAllStaffByMonthYear(String yearMonth) {

		List<SalaryByMonth> dsSalaryByMonth = new ArrayList<SalaryByMonth>();

		// update data work of user by yyyy/mm/dd
		for (int i = 1; i < 31; i++) {

			String query = yearMonth;
			if (i < 10) {
				query += "-0" + i;
			} else {
				query += "-" + i;
			}
			// get datework
			List<Datework> dsDatawork = dateworkRepository.findObjectById(query);
			if (dsDatawork != null && dsDatawork.size() >= 1) {
				Datework datework = dsDatawork.get(0);
				StringJoiner stringJoinerFullDay = new StringJoiner(",");
				StringJoiner stringJoinerHalfDay = new StringJoiner(",");

				// get dailyworking all staff by date
				List<Dailyworking> dsDateOfAllUser = getDailyworkingByDay(query);
				for (Dailyworking in : dsDateOfAllUser) {
					String checkWork = checkDateWork(in);
					if ("full".equals(checkWork)) {
						stringJoinerFullDay.add(in.getIdstaffwork());
					} else if ("half".equals(checkWork)) {
						stringJoinerHalfDay.add(in.getIdstaffwork());
					}
				}

				datework.setListuserworkfullday(stringJoinerFullDay.toString());
				datework.setListuserhalfday(stringJoinerHalfDay.toString());
				dateworkRepository.save(datework);
			}
		}

		// get only user on
		List<Staff> getListOnLyOnStatus = new ArrayList<Staff>();
		
		 for (MinaHoTelPojo in: staffRepository.findAll()) {
			 Staff staffObject = (Staff) in;
			 if(EnumTicketAndRoom.ON.getName().equals(staffObject.getStatus())) {
				 getListOnLyOnStatus.add(staffObject);
			 }
		 }

		for (int iStaff = 0; iStaff< getListOnLyOnStatus.size();iStaff++) {
			SalaryByMonth salaryStaff = new SalaryByMonth();
			Staff in = getListOnLyOnStatus.get(iStaff);
			salaryStaff.setIdStaff(in.getIdstaff());
			salaryStaff.setNameStaff(in.getUsername());
			salaryStaff.setRole(in.getRole());
			salaryStaff.setSalaryMonth(in.getSalarymonth());
			salaryStaff.setBonus(in.getBonussalary());
			Double numberWork = Double.valueOf(0);
			Double salaryMonth = in.getSalarymonth().doubleValue();
			Double salaryOneDay = salaryMonth / 30;
			Double salaryReal = Double.valueOf(1);

			for (int i = 1; i < 30; i++) {
				String query = yearMonth;
				if (i < 10) {
					query += "-0" + i;
				} else {
					query += "-"+i;
				}
				// get datework
				List<Datework> dsDatawork = dateworkRepository.findObjectById(query);
				if (dsDatawork != null && dsDatawork.size() >= 1) {
					Datework datework = dsDatawork.get(0);
					List<String> dslistStaffWorkFullDay = List.of(datework.getListuserworkfullday().split(","));
					List<String> dslistStaffWorkHalfDay = List.of(datework.getListuserhalfday().split(","));

					Optional<String> opIsFull = dslistStaffWorkFullDay.stream().filter(value -> value.equals(in.getIdstaff())).findFirst();
					
					if (opIsFull.isPresent()) {
						numberWork++;
					} else {
						Optional<String> opIsHalf  = dslistStaffWorkHalfDay.stream().filter(value -> value.equals(in.getIdstaff())).findFirst();
						if (opIsHalf.isPresent()) {
							numberWork += 0.5;
						}
					}
				}
			}

			salaryReal = numberWork * salaryOneDay + in.getBonussalary().doubleValue();
			salaryStaff.setNumberWork(numberWork);
			salaryStaff.setRealSalary(BigDecimal.valueOf(salaryReal).round(new MathContext(2, RoundingMode.HALF_EVEN)));
			dsSalaryByMonth.add(salaryStaff);
		}

		return dsSalaryByMonth;
	}

	String checkDateWork(Dailyworking in) {
		if (ChronoUnit.HOURS.between( in.getTimestart(), in.getTimeend()) >= 5) {
			return "full";
		} else {
			if (ChronoUnit.HOURS.between( in.getTimestart(), in.getTimeend()) > 0 
					&& ChronoUnit.HOURS.between( in.getTimestart(), in.getTimeend()) < 5) {
				return "half";
			}
		}
		return "off";
	}

	public List<Dailyworking> getDailyworkingByDay(String date) {
		// check if not exist then create day
		List<Dailyworking> lsDailyworkings = new ArrayList<Dailyworking>();
		LocalDate localDate = LocalDate.parse(date);
		Optional<Datework> datework = dateworkRepository.findObjectByIdOnlyOne(localDate);
		// check date work
		if (datework.isPresent()) {
			// check dailyworkingRepository

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
			}
		}
		return lsDailyworkings;
	}
}
