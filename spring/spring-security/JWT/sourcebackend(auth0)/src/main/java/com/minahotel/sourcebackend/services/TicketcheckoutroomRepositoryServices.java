package com.minahotel.sourcebackend.services;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minahotel.sourcebackend.enums.EnumDetailservicesStatus;
import com.minahotel.sourcebackend.enums.EnumTicketAndRoom;
import com.minahotel.sourcebackend.enums.EnumTypeofroom;
import com.minahotel.sourcebackend.pojo.CheckingOutRoomDamaged;
import com.minahotel.sourcebackend.pojo.Detailservices;
import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.pojo.Revenue;
import com.minahotel.sourcebackend.pojo.Room;
import com.minahotel.sourcebackend.pojo.Ticketbooking;
import com.minahotel.sourcebackend.pojo.Ticketcheckoutroom;
import com.minahotel.sourcebackend.pojo.Typeofroom;
import com.minahotel.sourcebackend.pojo.fontendsendto.TicketcheckoutroomFontEnd;
import com.minahotel.sourcebackend.repository.CheckingOutRoomDamagedRepository;
import com.minahotel.sourcebackend.repository.DetailservicesRepository;
import com.minahotel.sourcebackend.repository.RoomRepository;
import com.minahotel.sourcebackend.repository.TicketbookingRepository;
import com.minahotel.sourcebackend.repository.TicketcheckoutroomRepository;
import com.minahotel.sourcebackend.repository.TypeofroomRepository;

@Service
public class TicketcheckoutroomRepositoryServices implements MinaHotelServices {

	@Autowired
	TicketcheckoutroomRepository ticketcheckoutroomRepository;

	@Override
	public List<? extends MinaHoTelPojo> getAll() {
		return (List<Ticketcheckoutroom>) ticketcheckoutroomRepository.findAll();
	}

	@Override
	public List<? extends MinaHoTelPojo> getObjectById(String... id) {
		return (List<Ticketcheckoutroom>) ticketcheckoutroomRepository.findObjectById(id[0]);
	}

	@Autowired
	DetailservicesRepository detailservicesRepository;

	@Autowired
	TypeofroomRepository typeofroomRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	TicketbookingRepository ticketbookingRepository;

	@Autowired
	CheckingOutRoomDamagedRepository checkingOutRoomDamagedRepository;

	public TicketcheckoutroomFontEnd getObjectByIdTicketCheckin(String idticket, String numberroom) {
		TicketcheckoutroomFontEnd ticketcheckoutroom = new TicketcheckoutroomFontEnd();

		// get type room
		Optional<Room> opRoom = roomRepository.findObjectByIdOnlyOne(Integer.valueOf(numberroom));

		Optional<Typeofroom> typeofroom = typeofroomRepository.findObjectByIdOnlyOne(opRoom.get().getNametyperoom());

		// get ticket checking
		Optional<Ticketbooking> ticketbooking = ticketbookingRepository.findObjectByIdOnlyOne(idticket);

		// name: 'Nguyen van a',
		ticketcheckoutroom.setTicketbooking(ticketbooking.get());
		ticketcheckoutroom.setIdticketbooking(idticket);
		ticketcheckoutroom.setNumberroomrent(Integer.valueOf(numberroom));
		// identity: '30125684',
		// numberInRoom: '4',
		// timeStartRent: ' 2020/12/12 11:30:30',
		// timeRent: '2:30',
		LocalDateTime localDateNow = LocalDateTime.now();
		ticketcheckoutroom.setTimeendrent(localDateNow);
		Duration timeRent = Duration.between(ticketbooking.get().getTimestamprent(), localDateNow);
		String time = "Time rent room: " + timeRent.toDaysPart() + ":" + timeRent.toHoursPart() + ":"
				+ timeRent.toMinutesPart();
		ticketcheckoutroom.setTimeRent(time);
		// rateRent: '300000',
//		BigDecimal rateRent = typeofroom.get().getRoomratesdates().multiply(BigDecimal.valueOf(timeRent.toDaysPart()))
//				.add(typeofroom.get().getRoomrateshours().multiply(BigDecimal.valueOf(timeRent.toHoursPart())))
//				.add(typeofroom.get().getRoomrateshours().multiply(BigDecimal.valueOf(timeRent.toMinutesPart() / 60)));

		BigDecimal rateRent = calculatorRentRoom(typeofroom.get(), timeRent.toDaysPart(), timeRent.toHoursPart(),
				timeRent.toMinutesPart());
		ticketcheckoutroom.setRateRent(rateRent);

		// get detailservicesRepository rateServices
		BigDecimal sumServices = new BigDecimal(0);
		List<Detailservices> dsDetailService = detailservicesRepository.findObjectByIdTicket(idticket);
		if (dsDetailService != null && dsDetailService.size() != 0) {
//			dsDetailService.stream().forEach(value -> {
//				sumServices = sumServices.add(value.getSumaryservices());
//			});

			for (Detailservices in : dsDetailService) {
				sumServices = sumServices.add(in.getSumaryservices());
			}
		}
		ticketcheckoutroom.setRateservices(sumServices);

		// calculator roomSubCharge
		int numberRoomOver = 0;
		if (ticketbooking.get().getNumberinroom() > typeofroom.get().getNumberinroom()) {
			numberRoomOver = ticketbooking.get().getNumberinroom() - typeofroom.get().getNumberinroom();
		}
		ticketcheckoutroom.setRateSubChargeInRoom(typeofroom.get().getRoomratescharge());
		ticketcheckoutroom.setMaxRentNumberInRoom(typeofroom.get().getNumberinroom());
		ticketcheckoutroom
				.setRoomSubCharge(typeofroom.get().getRoomratescharge().multiply(BigDecimal.valueOf(numberRoomOver)));

		// get roomDamaged /getObjectByIdCheckIn
		Optional<CheckingOutRoomDamaged> damaged = checkingOutRoomDamagedRepository.getObjectByIdCheckIn(idticket);
		if (damaged.isPresent() && damaged.get().getStatus().equals(EnumDetailservicesStatus.DONE.getName())) {
			ticketcheckoutroom.setRoomDamaged(damaged.get().getSumaryindemnify());
			ticketcheckoutroom.setStatus(EnumDetailservicesStatus.DONE.getName());
			ticketcheckoutroom.setListDamaged(damaged.get().getListproductdamaded());
		} else {
			if (!damaged.isPresent()) {
				ticketcheckoutroom.setStatus(EnumDetailservicesStatus.SHIPPING.getName());
				ticketcheckoutroom.setRoomDamaged(BigDecimal.ZERO);
				CheckingOutRoomDamaged checkingOutRoomDamaged = new CheckingOutRoomDamaged();
				Long timeLong = System.currentTimeMillis();
				checkingOutRoomDamaged.setIdcheckingoutroomdamaded(String.valueOf(timeLong));
				checkingOutRoomDamaged.setIdticketbooking(idticket);
				checkingOutRoomDamaged.setStatus(EnumDetailservicesStatus.SHIPPING.getName());
				checkingOutRoomDamaged.setSumaryindemnify(BigDecimal.valueOf(0));
				checkingOutRoomDamaged.setListproductdamaded("");
				checkingOutRoomDamagedRepository.save(checkingOutRoomDamaged);
			} else {
				// get status
				ticketcheckoutroom.setStatus(damaged.get().getStatus());
			}
			ticketcheckoutroom.setRoomDamaged(BigDecimal.ZERO);
		}

		ticketcheckoutroom
				.setSumaryratesandservices(ticketcheckoutroom.getRateRent().add(ticketcheckoutroom.getRateservices())
						.add(ticketcheckoutroom.getRoomDamaged()).add(ticketcheckoutroom.getRoomSubCharge()));

		return ticketcheckoutroom;
	}

	BigDecimal calculatorRentRoom(Typeofroom type, long day, long h, long mi) {
		BigDecimal rentRoom = new BigDecimal(0);
		BigDecimal dayRent = type.getRoomratesdates().multiply(BigDecimal.valueOf(day));
		BigDecimal hourToday = new BigDecimal(0);
		if (h < 4) {
			hourToday = type.getRoomrateshours().multiply(BigDecimal.valueOf(h));
		} else if (h >= 4 && h <= 24) {
			hourToday = type.getRoomratesdates();
		}
		BigDecimal minutes = new BigDecimal(0);
		if (mi > 0) {
			minutes = type.getRoomrateshours();
		}
		return rentRoom.add(dayRent).add(hourToday).add(minutes);
	}

	@Override
	public boolean createObject(MinaHoTelPojo minapojo) {
		try {
			Ticketcheckoutroom objectConvertFromMina = (Ticketcheckoutroom) minapojo;
			// upadate off status ticket checkin
			Optional<Ticketbooking> ticket = ticketbookingRepository
					.findObjectByIdOnlyOne(objectConvertFromMina.getIdticketbooking());
			if (ticket.isPresent()) {
				Ticketbooking ticketObject = ticket.get();
				ticketObject.setStatus(EnumTicketAndRoom.OFF.getName());
				ticketbookingRepository.save(ticketObject);
			}

			LocalDateTime localDateNow = LocalDateTime.now();
			objectConvertFromMina.setIdticketcheckoutroom(localDateNow.toString());
			ticketcheckoutroomRepository.save(objectConvertFromMina);

			// upadate setIdcheckoutroom CheckingOutRoomDamaged
			Optional<CheckingOutRoomDamaged> checkingOutRoomDamaged = checkingOutRoomDamagedRepository
					.getObjectByIdCheckIn(objectConvertFromMina.getIdticketbooking());
			if (checkingOutRoomDamaged.isPresent()) {
				CheckingOutRoomDamaged checkingOutRoomDamageds = checkingOutRoomDamaged.get();
				checkingOutRoomDamageds.setIdcheckoutroom(objectConvertFromMina.getIdticketcheckoutroom());
				checkingOutRoomDamagedRepository.save(checkingOutRoomDamageds);
			}

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean saveOrUpdate(MinaHoTelPojo minapojo) {
		Ticketcheckoutroom objectConvertFromMina = (Ticketcheckoutroom) minapojo;
		Ticketcheckoutroom result = ticketcheckoutroomRepository
				.findObjectByIdOnlyOne(objectConvertFromMina.getIdticketcheckoutroom()).map(x -> {
					x.setIdstaffreceptionsupport(objectConvertFromMina.getIdstaffreceptionsupport());
					x.setIdticketbooking(objectConvertFromMina.getIdticketbooking());
					x.setNumberroomrent(objectConvertFromMina.getNumberroomrent());
					x.setSumaryratesandservices(objectConvertFromMina.getSumaryratesandservices());
					x.setTimeendrent(objectConvertFromMina.getTimeendrent());
					return ticketcheckoutroomRepository.save(x);
				}).orElseGet(() -> {
					return ticketcheckoutroomRepository.save(objectConvertFromMina);
				});
		return result != null ? true : false;
	}

	@Override
	public void deleteObject(MinaHoTelPojo minapojo) {
		Ticketcheckoutroom objectConvertFromMina = (Ticketcheckoutroom) minapojo;
		ticketcheckoutroomRepository.delete(objectConvertFromMina);
	}

	public List<Revenue> getRevenue() {

		List<Revenue> listRepose = new ArrayList<Revenue>();
		LocalDate nowdate = LocalDate.now();
		List<String> ls = getListday(nowdate);
		// get check out
		for (String date : ls) {
			Revenue re = new Revenue();
			re.setIddatework(LocalDate.parse(date).getDayOfMonth()+"/"+LocalDate.parse(date).getMonthValue());

			String queryParam = "%" + date + "%";
			List<Ticketcheckoutroom> op = ticketcheckoutroomRepository.findObjectByIdOnlyOneByDay(queryParam);
			if (op != null && op.size() > 0) {
				for (Ticketcheckoutroom ticketcheckout : op) {
					// check is type room
					Optional<Room> room = roomRepository.findObjectByIdOnlyOne(ticketcheckout.getNumberroomrent());
					if (EnumTypeofroom.SINGLE.getName().equals(room.get().getNametyperoom())) {
						re.setSingleRoom(re.getSingleRoom().add(ticketcheckout.getSumaryratesandservices()));
					} else if (EnumTypeofroom.DOUBLE.getName().equals(room.get().getNametyperoom())) {
						re.setDoubleRoom(re.getDoubleRoom().add(ticketcheckout.getSumaryratesandservices()));
					} else {
						re.setVipRoom(re.getVipRoom().add(ticketcheckout.getSumaryratesandservices()));
					}
				}
			} else {
				// default not value
			}
			listRepose.add(re);
		}
		return listRepose;
	}

	List<String> getListday(LocalDate now) {

		List<String> list = new ArrayList<String>();
		int i = 0;
		while (i < 15) {
			String minus = now.minusDays(i).toString();
			list.add(minus);
			i++;
		}

		Collections.reverse(list);

//		i = 0;
//		while (i < 10) {
//			String plus = now.plusDays(i).toString();
//			list.add(plus);
//			i++;
//		}

		return list;
	}
}
