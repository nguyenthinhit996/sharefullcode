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
import com.minahotel.sourcebackend.pojo.Revenue;
import com.minahotel.sourcebackend.pojo.Ticketcheckoutroom;
import com.minahotel.sourcebackend.services.TicketcheckoutroomRepositoryServices;

@RestController
public class TicketcheckoutroomController {

	@Autowired
	TicketcheckoutroomRepositoryServices ticketcheckoutroomRepositoryServices;
	
	@GetMapping("/Ticketcheckoutroom")
	List<? extends MinaHoTelPojo> getObjectById(@RequestParam(name = "id", defaultValue = "All") String id) {
		if("All".equals(id)) {
			return ticketcheckoutroomRepositoryServices.getAll();
		}
		 return ticketcheckoutroomRepositoryServices.getObjectById(id);
	}
	

	@GetMapping("/TicketcheckoutroombyIdTicket")
	MinaHoTelPojo getObjectByIdTicketCheckin(@RequestParam(name = "id") String id, @RequestParam(name = "numberroom") String numberroom) {
		 return ticketcheckoutroomRepositoryServices.getObjectByIdTicketCheckin(id,numberroom);
	}
	
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/Ticketcheckoutroom")
    boolean newObject(@RequestBody Ticketcheckoutroom object ) {
        return ticketcheckoutroomRepositoryServices.createObject(object);
    }
	

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/Ticketcheckoutroom")
    boolean saveOrUpdate(@RequestBody Ticketcheckoutroom object ) {
        return ticketcheckoutroomRepositoryServices.saveOrUpdate(object);
    }
    

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/Ticketcheckoutroom")
    void deleteObject(@RequestBody Ticketcheckoutroom object ) {
    	ticketcheckoutroomRepositoryServices.deleteObject(object);
    }
    
    @GetMapping("/Revenue")
    List<Revenue> Revenue() {
		 return ticketcheckoutroomRepositoryServices.getRevenue();
	}
}
