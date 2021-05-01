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

import com.minahotel.sourcebackend.pojo.Detailservices;
import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.pojo.fontendsendto.ListDetailservicesLinkFontEnd;
import com.minahotel.sourcebackend.pojo.fontendsendto.StatusServiceTableFontEnd;
import com.minahotel.sourcebackend.services.DetailservicesRepositoryServices;

@RestController
public class DetailservicesController {

	@Autowired
	DetailservicesRepositoryServices detailservicesRepositoryServices;
	

	@GetMapping("/Detailservices")
	List<? extends MinaHoTelPojo> getObjectById(@RequestParam(name = "idticketbooking", defaultValue = "All") String idticketbooking,
			@RequestParam(name = "idproduct", defaultValue = "All") String idproduct) {
		if("All".equals(idticketbooking)) {
			return detailservicesRepositoryServices.getAll();
		}
		 return detailservicesRepositoryServices.getObjectById(idticketbooking,idproduct);
	}
	
	@GetMapping("/DetailservicesByChecking")
	List<? extends MinaHoTelPojo> getObjectByIdTicket(@RequestParam(name = "idticketbooking") String idticketbooking){
		 return detailservicesRepositoryServices.getObjectByIdTicket(idticketbooking);
	}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/Detailservices")
    boolean newObject(@RequestBody Detailservices object ) {
        return detailservicesRepositoryServices.createObject(object);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/DetailservicesUpdate")
    boolean DetailservicesUpdate(@RequestBody ListDetailservicesLinkFontEnd object ) {
        return detailservicesRepositoryServices.DetailservicesUpdate(object);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/DetailservicesUpdateOneProduct")
    boolean DetailservicesUpdateByUserReception(@RequestBody Detailservices object ) {
        return detailservicesRepositoryServices.DetailservicesUpdateByUserReception(object);
    }
	

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/Detailservices")
    boolean saveOrUpdate(@RequestBody Detailservices object ) {
        return detailservicesRepositoryServices.saveOrUpdate(object);
    }
    

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/Detailservices")
    void deleteObject(@RequestBody Detailservices object ) {
    	detailservicesRepositoryServices.deleteObject(object);
    }
    
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getWorkAllStaffStatusServices")
    public List<? extends MinaHoTelPojo> getWorkAllStaffStatusServices() {
        return detailservicesRepositoryServices.getWorkAllStaffStatusServices();
    }
    
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/UpdateStatusServicesByUserServices")
    boolean UpdateStatusServices(@RequestBody StatusServiceTableFontEnd object ) {
        return detailservicesRepositoryServices.UpdateStatusServicesByUserServices(object);
    }
    
    
	@GetMapping("/DetailservicesInforDrinkAndFood")
	String getObjectByIdResponseString(@RequestParam(name = "idticketbooking", defaultValue = "All") String idticketbooking,
			@RequestParam(name = "idproduct", defaultValue = "All") String idproduct) {
		 return detailservicesRepositoryServices.getObjectByIdResponseString(idticketbooking,idproduct);
	}
}
