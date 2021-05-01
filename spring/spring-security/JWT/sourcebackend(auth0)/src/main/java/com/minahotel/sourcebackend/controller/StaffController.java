package com.minahotel.sourcebackend.controller;

import java.util.ArrayList;
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

import com.minahotel.sourcebackend.enums.EnumTicketAndRoom;
import com.minahotel.sourcebackend.pojo.ChangePassPojo;
import com.minahotel.sourcebackend.pojo.LoginPojo;
import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.pojo.Staff;
import com.minahotel.sourcebackend.services.StaffRepositoryServices;

 
@RestController()
public class StaffController {

	@Autowired
	StaffRepositoryServices staffRepositoryServices;
	
	// get all or get by idstaff
	@GetMapping("/staff")
	List<? extends MinaHoTelPojo> getStaffById(@RequestParam(name = "id", defaultValue = "All") String idStaff) {
		if("All".equals(idStaff)) {
			List<Staff> getListOnLyOnStatus = new ArrayList<Staff>();
			
			 for (MinaHoTelPojo in: staffRepositoryServices.getAll()) {
				 Staff staffObject = (Staff) in;
				 if(EnumTicketAndRoom.ON.getName().equals(staffObject.getStatus())) {
					 getListOnLyOnStatus.add(staffObject);
				 }
			 }
			 
			 return getListOnLyOnStatus;
		}
		 return staffRepositoryServices.getObjectById(idStaff);
	}
	
	//Save
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/staff")
    boolean newObject(@RequestBody Staff staff ) {
        return staffRepositoryServices.createObject(staff);
    }
	
    //update or insert 
    //return 200
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/staff")
    boolean saveOrUpdate(@RequestBody Staff staff ) {
        return staffRepositoryServices.saveOrUpdate(staff);
    }
    
    // delete
    //return 200
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/staff")
    void deleteStaff(@RequestBody Staff staff ) {
        staffRepositoryServices.deleteObject(staff);
    }
    
//    // Auth
//    //return 200
//    @ResponseStatus(HttpStatus.OK)
//    @PostMapping("/auth")
//    LoginPojo authStaff(@RequestBody LoginPojo loginPojo) {
//    	//System.out.println(username+" --------------- "+pass);    	
//    	staffRepositoryServices.checkLogin(loginPojo);
//    	return loginPojo;
//    }
    
    //return 200
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/changepass")
    public String changePass(@RequestBody ChangePassPojo loginPojo) {
    	//System.out.println(username+" --------------- "+pass);    	
    	return staffRepositoryServices.changePass(loginPojo);
    }
    
    //update or insert 
    //return 200
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/resetPass")
    boolean resetPassWord(@RequestBody String idStaff) {
    	staffRepositoryServices.resetPassword(idStaff);
       return true;
    }
}
