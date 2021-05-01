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
import com.minahotel.sourcebackend.pojo.TypeOfRoomAll;
import com.minahotel.sourcebackend.pojo.Typeofroom;
import com.minahotel.sourcebackend.services.TypeofroomRepositoryServies;

@RestController
public class TypeofroomController {

	@Autowired
	TypeofroomRepositoryServies TypeofroomRepositoryServies;
	

	@GetMapping("/Typeofroom")
	List<? extends MinaHoTelPojo> getObjectById(@RequestParam(name = "id", defaultValue = "All") String id) {
		if("All".equals(id)) {
			return TypeofroomRepositoryServies.getAll();
		}
		 return TypeofroomRepositoryServies.getObjectById(id);
	}
	

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/Typeofroom")
    boolean newObject(@RequestBody Typeofroom object ) {
        return TypeofroomRepositoryServies.createObject(object);
    }
	

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/Typeofroom")
    boolean saveOrUpdate(@RequestBody TypeOfRoomAll object ) {
        return TypeofroomRepositoryServies.saveOrUpdateAll(object);
    }
    

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/Typeofroom")
    void deleteObject(@RequestBody Typeofroom object ) {
    	TypeofroomRepositoryServies.deleteObject(object);
    }
}
