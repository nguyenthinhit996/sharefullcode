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
import com.minahotel.sourcebackend.pojo.Room;
import com.minahotel.sourcebackend.services.ProductionRepositoryServices;
import com.minahotel.sourcebackend.services.RoomRepositoryServices;

@RestController
public class RoomController {

	@Autowired
	RoomRepositoryServices roomRepositoryServices;
	

	@GetMapping("/Room")
	List<? extends MinaHoTelPojo> getObjectById(@RequestParam(name = "id", defaultValue = "All") String id) {
		if("All".equals(id)) {
			return roomRepositoryServices.getAll();
		}
		 return roomRepositoryServices.getObjectById(id);
	}
	

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/Room")
    boolean newObject(@RequestBody Room object ) {
        return roomRepositoryServices.createObject(object);
    }
	

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/Room")
    boolean saveOrUpdate(@RequestBody Room object ) {
        return roomRepositoryServices.saveOrUpdate(object);
    }
    

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/Room")
    void deleteObject(@RequestBody Room object ) {
    	roomRepositoryServices.deleteObject(object);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detailAllRoom")
	List<? extends MinaHoTelPojo> detailAllRoom() {
		 return roomRepositoryServices.detailAllRoom();
	}
}
