package com.minahotel.sourcebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.pojo.Ticketbooking;
import com.minahotel.sourcebackend.services.TicketbookingRepositoryServices;

@RestController
public class TicketbookingController {

	@Autowired
	TicketbookingRepositoryServices ticketbookingRepositoryServices;
	

	@GetMapping("/Ticketbooking")
	List<? extends MinaHoTelPojo> getObjectById(@RequestParam(name = "id", defaultValue = "All") String id) {
		if("All".equals(id)) {
			return ticketbookingRepositoryServices.getAll();
		}
		 return ticketbookingRepositoryServices.getObjectById(id);
	}
	

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/Ticketbooking")
    boolean newObject(@RequestBody Ticketbooking object ) {
        return ticketbookingRepositoryServices.createObject(object);
    }
	

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/Ticketbooking")
    boolean saveOrUpdate(@RequestBody Ticketbooking object ) {
        return ticketbookingRepositoryServices.saveOrUpdate(object);
    }
    

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/Ticketbooking")
    void deleteObject(@RequestBody Ticketbooking object ) {
    	ticketbookingRepositoryServices.deleteObject(object);
    }
}
