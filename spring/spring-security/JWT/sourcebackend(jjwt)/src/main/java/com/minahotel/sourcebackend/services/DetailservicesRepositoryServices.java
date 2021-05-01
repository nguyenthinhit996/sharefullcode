package com.minahotel.sourcebackend.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.minahotel.sourcebackend.enums.EnumDetailservicesStatus;
import com.minahotel.sourcebackend.enums.EnumTicketAndRoom;
import com.minahotel.sourcebackend.enums.EnumTypeServices;
import com.minahotel.sourcebackend.pojo.CheckingOutRoomDamaged;
import com.minahotel.sourcebackend.pojo.Detailservices;
import com.minahotel.sourcebackend.pojo.DetailservicesLinkFontEnd;
import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.pojo.Production;
import com.minahotel.sourcebackend.pojo.Staff;
import com.minahotel.sourcebackend.pojo.Ticketbooking;
import com.minahotel.sourcebackend.pojo.Ticketcheckoutroom;
import com.minahotel.sourcebackend.pojo.fontendsendto.ListDetailservicesLinkFontEnd;
import com.minahotel.sourcebackend.pojo.fontendsendto.StatusServiceTableFontEnd;
import com.minahotel.sourcebackend.repository.CheckingOutRoomDamagedRepository;
import com.minahotel.sourcebackend.repository.DetailservicesRepository;
import com.minahotel.sourcebackend.repository.ProductionRepository;
import com.minahotel.sourcebackend.repository.StaffRepository;
import com.minahotel.sourcebackend.repository.TicketbookingRepository;
import com.minahotel.sourcebackend.repository.TicketcheckoutroomRepository;

@Service
public class DetailservicesRepositoryServices implements MinaHotelServices {

	@Autowired
	DetailservicesRepository detailservicesRepository;

	@Override
	public List<? extends MinaHoTelPojo> getAll() {
		return (List<Detailservices>) detailservicesRepository.findAll();
	}

	@Override
	public List<? extends MinaHoTelPojo> getObjectById(String... id) {
		return (List<Detailservices>) detailservicesRepository.findObjectById(id[0], id[1]);
	}
	
 
	
	public String getObjectByIdResponseString(String ...id) {		
		Optional<Detailservices> detailservices = detailservicesRepository.findObjectByIdOnlyOne(id[0], id[1]);
		if(detailservices.isPresent()) {
			
			// get id product
			Optional<Production> production = productionRepository.findObjectByIdOnlyOne(detailservices.get().getIdproduct());
			
			Optional<Ticketbooking> ticketbooking = ticketbookingRepository.findObjectByIdOnlyOne(detailservices.get().getIdticketbooking());
			
			String message = "Send ("+ detailservices.get().getAmount() +") Product ["+
			production.get().getNameproduct() +"] To Room: "+ 
					ticketbooking.get().getNumberroom() + " ("+production.get().getExtention()+")";
		
			return message;
		}
		return "Error missing ! refesh page";
	}

	public List<? extends MinaHoTelPojo> getObjectByIdTicket(String... id) {
		List<Detailservices> dsDetailService = (List<Detailservices>) detailservicesRepository
				.findObjectByIdTicket(id[0]);
		List<DetailservicesLinkFontEnd> productListReturnFontend = new ArrayList<DetailservicesLinkFontEnd>();
		dsDetailService.stream().forEach(value -> {
			DetailservicesLinkFontEnd detailservicesLinkFontEnd = new DetailservicesLinkFontEnd(9);
			detailservicesLinkFontEnd.getDetailservices().setIdproduct(value.getIdproduct());
			detailservicesLinkFontEnd.getDetailservices().setIdstaffservicesrepo(value.getIdstaffservicesrepo());
			detailservicesLinkFontEnd.getDetailservices().setIdticketbooking(value.getIdticketbooking());
			detailservicesLinkFontEnd.getDetailservices().setSumaryservices(value.getSumaryservices());
			if(EnumDetailservicesStatus.TODO.getName().equals(value.getStatus())){
				// View TODO -> SHIPPING only user staff reception
				detailservicesLinkFontEnd.getDetailservices().setStatus(EnumDetailservicesStatus.SHIPPING.getName());
			}else {
				detailservicesLinkFontEnd.getDetailservices().setStatus(value.getStatus());
			}
		
			detailservicesLinkFontEnd.getDetailservices().setAmount(value.getAmount());
			detailservicesLinkFontEnd.getDetailservices().setStartrent(value.getStartrent());
			detailservicesLinkFontEnd.getDetailservices().setEndrent(value.getEndrent());
			// get proudct by id
			Optional<Production> opProduct = productionRepository.findObjectByIdOnlyOne(value.getIdproduct());
			if (opProduct.isPresent()) {
				// set product
				detailservicesLinkFontEnd.setProduction(opProduct.get());
			}
			productListReturnFontend.add(detailservicesLinkFontEnd);
		});
		return productListReturnFontend;
	}

	public Boolean DetailservicesUpdate(ListDetailservicesLinkFontEnd object) {
		if (object != null) {
			try {
				List<DetailservicesLinkFontEnd> dsDetailservicesLinkFontEnd = object.getDsDetailservicesLinkFontEnd();
				dsDetailservicesLinkFontEnd.stream().forEach(value -> {
					DetailservicesLinkFontEnd detailservicesLinkFontEnd = value;
					Detailservices detailservices = detailservicesLinkFontEnd.getDetailservices();
					if (EnumDetailservicesStatus.CANCEL.getName().equals(detailservices.getStatus())) {
						// get it then delete it
						Detailservices deteleObject = (Detailservices) getObjectById(
								detailservices.getIdticketbooking(), detailservices.getIdproduct()).get(0);
						// detele row
						deleteObject(deteleObject);
					} else {
						// update row
						saveOrUpdate(detailservices);
					}
				});
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public Boolean DetailservicesUpdateByUserReception(Detailservices detailservices) {
		try {
			if (EnumDetailservicesStatus.CANCEL.getName().equals(detailservices.getStatus())) {
				// get it then delete it
				Detailservices deteleObject = (Detailservices) getObjectById(detailservices.getIdticketbooking(),
						detailservices.getIdproduct()).get(0);
				// detele row
				deleteObject(deteleObject);
			} else {
				if (EnumDetailservicesStatus.DONE.getName().equals(detailservices.getStatus())) {
					LocalDateTime localDateNow = LocalDateTime.now();
					detailservices.setEndrent(localDateNow);
				}
				// update row
				update(detailservices);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean createObject(MinaHoTelPojo minapojo) {
		try {
			Detailservices objectConvertFromMina = (Detailservices) minapojo;
			BigDecimal moneyOfProduct = getMoneyOfProductById(objectConvertFromMina.getIdproduct());
			objectConvertFromMina.setSumaryservices(moneyOfProduct);
			LocalDateTime localDateNow = LocalDateTime.now();
			objectConvertFromMina.setStartrent(localDateNow);
			detailservicesRepository.save(objectConvertFromMina);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean saveOrUpdate(MinaHoTelPojo minapojo) {
		Detailservices objectCheckSuccess = null;
		Detailservices objectConvertFromMina = (Detailservices) minapojo;
		BigDecimal moneyOfProduct = getMoneyOfProductById(objectConvertFromMina.getIdproduct());
		Optional<Detailservices> result = detailservicesRepository.findObjectByIdOnlyOne(
				objectConvertFromMina.getIdticketbooking(), objectConvertFromMina.getIdproduct());
		if (result.isPresent()) {
			Detailservices objectUpdate = result.get();
			detailservicesRepository.delete(objectUpdate);
			int updateAmount = objectUpdate.getAmount() + objectConvertFromMina.getAmount();
			objectUpdate.setAmount(updateAmount);
			objectUpdate.setEndrent(objectConvertFromMina.getEndrent());
			objectUpdate.setIdstaffservicesrepo(objectConvertFromMina.getIdstaffservicesrepo());
			objectUpdate.setStartrent(objectConvertFromMina.getStartrent());
			objectUpdate.setStatus(objectConvertFromMina.getStatus());
			BigDecimal summary = moneyOfProduct.multiply(BigDecimal.valueOf(updateAmount));
			objectUpdate.setSumaryservices(summary);
			objectCheckSuccess = detailservicesRepository.save(objectUpdate);
		} else {
			objectConvertFromMina.setSumaryservices(moneyOfProduct);
			LocalDateTime localDateNow = LocalDateTime.now();
			objectConvertFromMina.setStartrent(localDateNow);
			objectCheckSuccess = detailservicesRepository.save(objectConvertFromMina);
		}
		return objectCheckSuccess != null ? true : false;
	}

	public boolean update(MinaHoTelPojo minapojo) {
		Detailservices objectCheckSuccess = null;
		Detailservices objectConvertFromMina = (Detailservices) minapojo;
		BigDecimal moneyOfProduct = getMoneyOfProductById(objectConvertFromMina.getIdproduct());
		Optional<Detailservices> result = detailservicesRepository.findObjectByIdOnlyOne(
				objectConvertFromMina.getIdticketbooking(), objectConvertFromMina.getIdproduct());
		if (result.isPresent()) {
			Detailservices objectUpdate = result.get();
			detailservicesRepository.delete(objectUpdate);
			objectUpdate.setAmount(objectConvertFromMina.getAmount());
			objectUpdate.setEndrent(objectConvertFromMina.getEndrent());
			objectUpdate.setIdstaffservicesrepo(objectConvertFromMina.getIdstaffservicesrepo());
			objectUpdate.setStartrent(objectConvertFromMina.getStartrent());
			objectUpdate.setStatus(objectConvertFromMina.getStatus());
			BigDecimal summary = moneyOfProduct.multiply(BigDecimal.valueOf(objectConvertFromMina.getAmount()));
			objectUpdate.setSumaryservices(summary);
			objectCheckSuccess = detailservicesRepository.save(objectUpdate);
		} else {
			// new product into table detail services
			objectConvertFromMina.setSumaryservices(moneyOfProduct);
			LocalDateTime localDateNow = LocalDateTime.now();
			objectConvertFromMina.setStartrent(localDateNow);
			objectCheckSuccess = detailservicesRepository.save(objectConvertFromMina);
		}
		return objectCheckSuccess != null ? true : false;
	}

	@Override
	public void deleteObject(MinaHoTelPojo minapojo) {
		Detailservices objectConvertFromMina = (Detailservices) minapojo;
		detailservicesRepository.delete(objectConvertFromMina);
	}

	public void deleteObjectByIdTicketAndIdProduct(MinaHoTelPojo minapojo) {
		Detailservices objectConvertFromMina = (Detailservices) minapojo;
		detailservicesRepository.deleteObjectByIdTicketAndIdProduct(objectConvertFromMina.getIdticketbooking(),
				objectConvertFromMina.getIdproduct());

	}

	@Autowired
	ProductionRepository productionRepository;

	BigDecimal getMoneyOfProductById(String id) {
		return productionRepository.findObjectById(id).get(0).getProductrates();
	}

	@Autowired
	CheckingOutRoomDamagedRepository checkingOutRoomDamagedRepository;

	@Autowired
	TicketbookingRepository ticketbookingRepository;

	@Autowired
	TicketcheckoutroomRepository ticketcheckoutroomRepository;

	@Autowired
	private StaffRepository staffRepository;

	public List<? extends MinaHoTelPojo> getWorkAllStaffStatusServices() {
		List<StatusServiceTableFontEnd> resultReponse = new ArrayList<StatusServiceTableFontEnd>();
		// 3 table
		// checkingoutroomdamaged check hu hai Todo -> Done
		List<CheckingOutRoomDamaged> dsCheckingOutRoomDamaged = (List<CheckingOutRoomDamaged>) checkingOutRoomDamagedRepository
				.findAll();
		if (dsCheckingOutRoomDamaged != null && dsCheckingOutRoomDamaged.size() > 0) {
			for (CheckingOutRoomDamaged in : dsCheckingOutRoomDamaged) {
				StatusServiceTableFontEnd statusServiceTableFontEnd = new StatusServiceTableFontEnd();
				statusServiceTableFontEnd.setDetailservicesidproduct(null);
				statusServiceTableFontEnd.setDetailservicesIdticketbooking(null);
				statusServiceTableFontEnd.setIdcheckingoutroomdamaded(in.getIdcheckingoutroomdamaded());

				Optional<Staff> staff = staffRepository.findStaffByIdOnlyOne(in.getIdstaffchecking());
				if (staff.isPresent()) {
					statusServiceTableFontEnd.setUsername(staff.get().getUsername());
				}
				statusServiceTableFontEnd.setIdstaff(in.getIdstaffchecking()); // update to Todo status
				statusServiceTableFontEnd.setIdticketcheckoutroom(in.getIdcheckoutroom());
				// get checkin to order to get numberRoom
				Optional<Ticketbooking> ticketbooking = ticketbookingRepository
						.findObjectByIdOnlyOne(in.getIdticketbooking());
				if (ticketbooking.isPresent()) {
					statusServiceTableFontEnd.setNumberroom(ticketbooking.get().getNumberroom());
				} else {
					statusServiceTableFontEnd.setNumberroom(-1);
				}
				statusServiceTableFontEnd.setTypeservices(EnumTypeServices.CHECKOUTDAMAGED.getName());
				statusServiceTableFontEnd.setStatus(in.getStatus());
				resultReponse.add(statusServiceTableFontEnd);
			}
		}

		// ticketcheckoutroom cap nhat tu clean -> off
		List<Ticketcheckoutroom> dsTicketcheckoutroom = (List<Ticketcheckoutroom>) ticketcheckoutroomRepository
				.findAll();
		if (dsTicketcheckoutroom != null && dsTicketcheckoutroom.size() > 0) {
			for (Ticketcheckoutroom in : dsTicketcheckoutroom) {
//				if(EnumTicketAndRoom.OFF.getName().equals(in.getStatus())) {
//					
//				}
				StatusServiceTableFontEnd statusServiceTableFontEnd = new StatusServiceTableFontEnd();
				statusServiceTableFontEnd.setDetailservicesidproduct(null);
				statusServiceTableFontEnd.setDetailservicesIdticketbooking(null);
				statusServiceTableFontEnd.setIdticketcheckoutroom(in.getIdticketcheckoutroom());
				if (EnumTicketAndRoom.CLEAN.getName().equals(in.getStatus())) {
					statusServiceTableFontEnd.setStatus(EnumDetailservicesStatus.TODO.getName()); // set ToDo not set																									// Shipping
				} else {
					statusServiceTableFontEnd.setStatus(in.getStatus());
				}
				statusServiceTableFontEnd.setTypeservices(EnumTypeServices.CLEANROOM.getName());
				statusServiceTableFontEnd.setNumberroom(in.getNumberroomrent());
				Optional<CheckingOutRoomDamaged> checkingOutRoomDamaged = checkingOutRoomDamagedRepository
						.getObjectByIdCheckIn(in.getIdticketbooking());
				if (checkingOutRoomDamaged.isPresent()) {
					statusServiceTableFontEnd
							.setIdcheckingoutroomdamaded(checkingOutRoomDamaged.get().getIdcheckingoutroomdamaded());
					statusServiceTableFontEnd.setIdstaff(checkingOutRoomDamaged.get().getIdstaffchecking());
					Optional<Staff> staff = staffRepository
							.findStaffByIdOnlyOne(checkingOutRoomDamaged.get().getIdstaffchecking());
					if (staff.isPresent()) {
						statusServiceTableFontEnd.setUsername(staff.get().getUsername());
					}
				}
				resultReponse.add(statusServiceTableFontEnd);
			}
		}

		// detailservices prepare-> shipping ( reception send to user service) ->
		// Todo(userservices doing) -> Done
		List<Detailservices> dsDetailservices = (List<Detailservices>) detailservicesRepository.findAll();
		if (dsDetailservices != null && dsDetailservices.size() > 0) {
			for (Detailservices in : dsDetailservices) {

				// only get shipping
				if (!EnumDetailservicesStatus.PREPARE.getName().equals(in.getStatus())) {

					StatusServiceTableFontEnd statusServiceTableFontEnd = new StatusServiceTableFontEnd();
					statusServiceTableFontEnd.setDetailservicesidproduct(in.getIdproduct());
					statusServiceTableFontEnd.setDetailservicesIdticketbooking(in.getIdticketbooking());
					statusServiceTableFontEnd.setIdticketcheckoutroom(null);
					statusServiceTableFontEnd.setStatus(in.getStatus());
					// get type product
					Optional<Production> production = productionRepository.findObjectByIdOnlyOne(in.getIdproduct());
					if (production.isPresent()) {
						statusServiceTableFontEnd.setTypeservices(production.get().getType());
					} else {
						statusServiceTableFontEnd.setTypeservices(EnumTypeServices.DRINKANDFOOD.getName());
					}

					// get checkin to order to get numberRoom
					Optional<Ticketbooking> ticketbooking = ticketbookingRepository
							.findObjectByIdOnlyOne(in.getIdticketbooking());
					if (ticketbooking.isPresent()) {
						statusServiceTableFontEnd.setNumberroom(ticketbooking.get().getNumberroom());
					} else {
						statusServiceTableFontEnd.setNumberroom(-1);
					}
					statusServiceTableFontEnd.setIdcheckingoutroomdamaded(null);
					Optional<Staff> staff = staffRepository.findStaffByIdOnlyOne(in.getIdstaffservicesrepo());
					if (staff.isPresent()) {
						statusServiceTableFontEnd.setUsername(staff.get().getUsername());
					}
					statusServiceTableFontEnd.setIdstaff(in.getIdstaffservicesrepo());
					resultReponse.add(statusServiceTableFontEnd);
				}

			}
		}

		return resultReponse;
	}

	public Boolean UpdateStatusServicesByUserServices(StatusServiceTableFontEnd object) {

		try {
			if (EnumTypeServices.CHECKOUTDAMAGED.getName().equals(object.getTypeservices())) {
				Optional<CheckingOutRoomDamaged> result = checkingOutRoomDamagedRepository
						.findObjectByIdOnlyOne(object.getIdcheckingoutroomdamaded());
				if (result.isPresent()) {
					CheckingOutRoomDamaged checkingOutRoomDamaged = result.get();
					checkingOutRoomDamaged.setStatus(object.getStatus());
					checkingOutRoomDamaged.setIdstaffchecking(object.getIdstaff());
					checkingOutRoomDamagedRepository.save(checkingOutRoomDamaged);
				}
			} else if (EnumTypeServices.CLEANROOM.getName().equals(object.getTypeservices())) {
				Optional<Ticketcheckoutroom> result = ticketcheckoutroomRepository
						.findObjectByIdOnlyOne(object.getIdticketcheckoutroom());
				if (result.isPresent()) {
					Ticketcheckoutroom ticketcheckoutroom = result.get();
					if (EnumDetailservicesStatus.DONE.getName().equals(object.getStatus())) {
						ticketcheckoutroom.setStatus(EnumTicketAndRoom.OFF.getName());
						ticketcheckoutroom.setIdstaffreceptionsupport(object.getIdstaff());
						ticketcheckoutroomRepository.save(ticketcheckoutroom);
					}
				}
			} else {
				Optional<Detailservices> result = detailservicesRepository.findObjectByIdOnlyOne(
						object.getDetailservicesIdticketbooking(), object.getDetailservicesidproduct());
				if (result.isPresent()) {
					Detailservices detailservices = result.get();
					detailservicesRepository.delete(detailservices);
					detailservices.setIdstaffservicesrepo(object.getIdstaff());
					detailservices.setStatus(object.getStatus());
					if(EnumDetailservicesStatus.DONE.getName().equals(object.getStatus())) {
						LocalDateTime localDateNow = LocalDateTime.now();
						detailservices.setEndrent(localDateNow);
					}
					detailservicesRepository.save(detailservices);
				}
			}
		} catch (Exception e) {
			return false;
		}

		return true;
	}
}
