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

import com.minahotel.sourcebackend.pojo.Datework;
import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.services.DateworkRepositoryServices;

@RestController
public class DateworkController {

	@Autowired
	DateworkRepositoryServices dateworkRepositoryServices;
	

	@GetMapping("/Datework")
	List<? extends MinaHoTelPojo> getObjectById(@RequestParam(name = "id", defaultValue = "All") String id) {
		if("All".equals(id)) {
			return dateworkRepositoryServices.getAll();
		}
		 return dateworkRepositoryServices.getObjectById(id);
	}
	

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/Datework")
    boolean newObject(@RequestBody Datework object ) {
        return dateworkRepositoryServices.createObject(object);
    }
	

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/Datework")
    boolean saveOrUpdate(@RequestBody Datework object ) {
        return dateworkRepositoryServices.saveOrUpdate(object);
    }
    

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/Datework")
    void deleteObject(@RequestBody Datework object ) {
    	dateworkRepositoryServices.deleteObject(object);
    }
    
    @GetMapping("/Salary")
	List<? extends MinaHoTelPojo> getSalaryAllStaffByMonth(@RequestParam(name = "month", defaultValue = "All") String id) {
		 return dateworkRepositoryServices.getSalaryAllStaffByMonthYear(id);
	}
}
