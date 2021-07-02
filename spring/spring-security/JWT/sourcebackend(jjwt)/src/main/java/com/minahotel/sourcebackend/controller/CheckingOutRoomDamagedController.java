package com.minahotel.sourcebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minahotel.sourcebackend.pojo.CheckingOutRoomDamaged;
import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.services.CheckingOutRoomDamagedRepositoryServices;

@RestController
public class CheckingOutRoomDamagedController {


	@Autowired
	CheckingOutRoomDamagedRepositoryServices checkingOutRoomDamagedRepositoryServices;
	

	@GetMapping("/CheckingOutRoomDamaged")
	List<? extends MinaHoTelPojo> getObjectById(@RequestParam(name = "id", defaultValue = "All") String id) {
		if("All".equals(id)) {
			return checkingOutRoomDamagedRepositoryServices.getAll();
		}
		 return checkingOutRoomDamagedRepositoryServices.getObjectById(id);
	}
	

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/CheckingOutRoomDamaged")
    boolean newObject(@RequestBody CheckingOutRoomDamaged object ) {
        return checkingOutRoomDamagedRepositoryServices.createObject(object);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/UpdateCheckingOutRoomDamaged")
    Boolean updateObject(@RequestBody CheckingOutRoomDamaged object ) {
        return checkingOutRoomDamagedRepositoryServices.updateObject(object);
    }
	

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/CheckingOutRoomDamaged")
    boolean saveOrUpdate(@RequestBody CheckingOutRoomDamaged object ) {
        return checkingOutRoomDamagedRepositoryServices.saveOrUpdate(object);
    }
    

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/CheckingOutRoomDamaged")
    void deleteObject(@RequestBody CheckingOutRoomDamaged object ) {
    	checkingOutRoomDamagedRepositoryServices.deleteObject(object);
    }
    
}
