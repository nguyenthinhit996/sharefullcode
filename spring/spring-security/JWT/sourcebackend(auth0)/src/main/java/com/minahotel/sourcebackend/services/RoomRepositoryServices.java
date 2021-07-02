package com.minahotel.sourcebackend.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minahotel.sourcebackend.enums.EnumTicketAndRoom;
import com.minahotel.sourcebackend.pojo.CheckingOutRoomDamaged;
import com.minahotel.sourcebackend.pojo.DetailRoom;
import com.minahotel.sourcebackend.pojo.Detailservices;
import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.pojo.Room;
import com.minahotel.sourcebackend.pojo.Ticketbooking;
import com.minahotel.sourcebackend.pojo.Ticketcheckoutroom;
import com.minahotel.sourcebackend.repository.DetailservicesRepository;
import com.minahotel.sourcebackend.repository.RoomRepository;
import com.minahotel.sourcebackend.repository.TicketbookingRepository;
import com.minahotel.sourcebackend.repository.TicketcheckoutroomRepository;

@Service
public class RoomRepositoryServices implements MinaHotelServices {

	@Autowired
	RoomRepository roomRepository;

	@Override
	public List<? extends MinaHoTelPojo> getAll() {
		return (List<Room>) roomRepository.findAll();
	}

	@Override
	public List<? extends MinaHoTelPojo> getObjectById(String... id) {
		return (List<Room>) roomRepository.findObjectById(id[0]);
	}

	@Override
	public boolean createObject(MinaHoTelPojo minapojo) {
		try {
			Room objectConvertFromMina = (Room) minapojo;
			roomRepository.save(objectConvertFromMina);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean saveOrUpdate(MinaHoTelPojo minapojo) {
		Room objectConvertFromMina = (Room) minapojo;
		Room result = roomRepository.findObjectByIdOnlyOne(objectConvertFromMina.getIdroom()).map(x -> {
			x.setNametyperoom(objectConvertFromMina.getNametyperoom());
			x.setStatus(objectConvertFromMina.getStatus());
			return roomRepository.save(x);
		}).orElseGet(() -> {
			return roomRepository.save(objectConvertFromMina);
		});
		return result != null ? true : false;
	}

	@Override
	public void deleteObject(MinaHoTelPojo minapojo) {
		Room objectConvertFromMina = (Room) minapojo;
		roomRepository.delete(objectConvertFromMina);
	}

	@Autowired
	TicketbookingRepository ticketbookingRepository;
	
	@Autowired
	CheckingOutRoomDamagedRepositoryServices CheckingOutRoomDamagedRepositoryServices;

	@Autowired
	TicketcheckoutroomRepository ticketcheckoutroomRepository;

	public List<? extends MinaHoTelPojo> detailAllRoom() {
		// get all room
		List<Room> allRoom = (List<Room>) roomRepository.findAll();

		// get all ticket
		List<Ticketbooking> allTicket = ticketbookingRepository.findObjectByIdPerform();

		// get cleaner checkout room
		List<Ticketcheckoutroom> allCheckOut = ticketcheckoutroomRepository.findRoomCheckoutCleaning();

		List<DetailRoom> allRoomWithStatusDetail = new ArrayList<DetailRoom>();

		allRoom.stream().forEach(room -> {
			DetailRoom detailRoom = new DetailRoom();
			detailRoom.setNumberRoom(room.getIdroom());
			detailRoom.setTypeRoom(room.getNametyperoom());
			Optional<Ticketbooking> opTkroom = allTicket.stream()
					.filter(ticket -> ticket.getNumberroom() == room.getIdroom() && ticket.getStatus().equals(EnumTicketAndRoom.ON.getName()) ).findFirst();
			if (opTkroom.isPresent()) {
				detailRoom.setIsClean(false);
				detailRoom.setIsEmpty(false);
				detailRoom.setIsFull(true);
				detailRoom.setNameRent(opTkroom.get().getUsernamerentroom());
				detailRoom.setNameCLean("Not Clean");
				detailRoom.setTimeStartRent(opTkroom.get().getTimestamprent());
				LocalDateTime localDateNow = LocalDateTime.now();
				Duration timeRent = Duration.between(opTkroom.get().getTimestamprent(), localDateNow);				
				String time = timeRent.toDaysPart() +":"+ timeRent.toHoursPart() + ":" + timeRent.toMinutesPart();
				detailRoom.setTimeRent(time);
				detailRoom.setTimeClean("0");
				detailRoom.setIdticketbooking(opTkroom.get().getIdticketbooking());
			} else {
				Optional<Ticketcheckoutroom> ckRoom = allCheckOut.stream().filter(
						ticket -> ticket.getNumberroomrent() == room.getIdroom() && ticket.getStatus().equals(EnumTicketAndRoom.CLEAN.getName()))
						.findFirst();
				if (ckRoom.isPresent()) {
					// get checkout room damaded
					Optional<CheckingOutRoomDamaged> roomdameged =
							 CheckingOutRoomDamagedRepositoryServices.getObjectByIdCheckOut(ckRoom.get().getIdticketcheckoutroom());
					detailRoom.setIsClean(true);
					detailRoom.setIsEmpty(false);
					detailRoom.setIsFull(false);
					detailRoom.setNameCLean(roomdameged.get().getIdstaffchecking());
					detailRoom.setTimeStartClean(ckRoom.get().getTimeendrent());
					LocalDateTime localDateNow = LocalDateTime.now();
					Duration timeRent = Duration.between(ckRoom.get().getTimeendrent(), localDateNow);
					String time = timeRent.toDaysPart() +":"+ timeRent.toHoursPart() + ":" + timeRent.toMinutesPart();
					detailRoom.setTimeClean(time);
				}else {
					detailRoom.setIsClean(false);
					detailRoom.setIsEmpty(true);
					detailRoom.setIsFull(false);
				}
			}
			
			allRoomWithStatusDetail.add(detailRoom);
		});

		return allRoomWithStatusDetail;
	}
}
