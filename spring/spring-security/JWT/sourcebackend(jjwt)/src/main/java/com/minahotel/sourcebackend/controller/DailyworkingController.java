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

import com.minahotel.sourcebackend.pojo.Dailyworking;
import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.services.DailyworkingRepositoryServices;

@RestController
public class DailyworkingController {

	@Autowired
	DailyworkingRepositoryServices dailyworkingRepositoryServices;
	

	@GetMapping("/Dailyworking")
	List<? extends MinaHoTelPojo> getObjectById(@RequestParam(name = "idtoday", defaultValue = "All") String idtoday) {
		if("All".equals(idtoday)) {
			return dailyworkingRepositoryServices.getAll();
		}
		 return dailyworkingRepositoryServices.getObjectById(idtoday);
	}
	

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/Dailyworking")
    boolean newObject(@RequestBody Dailyworking object ) {
        return dailyworkingRepositoryServices.createObject(object);
    }
	

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/Dailyworking")
    boolean saveOrUpdate(@RequestBody Dailyworking object ) {
        return dailyworkingRepositoryServices.saveOrUpdate(object);
    }
    

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/Dailyworking")
    void deleteObject(@RequestBody Dailyworking object ) {
    	dailyworkingRepositoryServices.deleteObject(object);
    }
    
	// get all or get by idstaff
	@GetMapping("/autotime")
	void getStaffById() {
		 dailyworkingRepositoryServices.autotime();
	}
}
