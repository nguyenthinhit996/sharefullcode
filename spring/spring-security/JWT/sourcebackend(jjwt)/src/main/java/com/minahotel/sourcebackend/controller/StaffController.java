package com.minahotel.sourcebackend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minahotel.sourcebackend.common.WebUtil;
import com.minahotel.sourcebackend.enums.EnumTicketAndRoom;
import com.minahotel.sourcebackend.pojo.ChangePassPojo;
import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.pojo.Staff;
import com.minahotel.sourcebackend.security.JwtUtil;
import com.minahotel.sourcebackend.services.StaffRepositoryServices;

import io.jsonwebtoken.impl.DefaultClaims;

@RestController()
public class StaffController {

	Logger LOGGER = LoggerFactory.getLogger(StaffController.class.toString());

	@Autowired
	StaffRepositoryServices staffRepositoryServices;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	JwtUtil jwtUtil;

	// get all or get by idstaff
	@GetMapping("/staff")
	List<? extends MinaHoTelPojo> getStaffById(@RequestParam(name = "id", defaultValue = "All") String idStaff) {
		if ("All".equals(idStaff)) {
			List<Staff> getListOnLyOnStatus = new ArrayList<Staff>();

			for (MinaHoTelPojo in : staffRepositoryServices.getAll()) {
				Staff staffObject = (Staff) in;
				if (EnumTicketAndRoom.ON.getName().equals(staffObject.getStatus())) {
					getListOnLyOnStatus.add(staffObject);
				}
			}
			return getListOnLyOnStatus;
		}
		return staffRepositoryServices.getObjectById(idStaff);
	}

	// Save
	// return 201 instead of 200
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/staff")
	boolean newObject(@RequestBody Staff staff) {
		return staffRepositoryServices.createObject(staff);
	}

	// update or insert
	// return 200
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/staff")
	boolean saveOrUpdate(@RequestBody Staff staff) {
		return staffRepositoryServices.saveOrUpdate(staff);
	}

	// delete
	// return 200
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/staff")
	void deleteStaff(@RequestBody Staff staff) {
		staffRepositoryServices.deleteObject(staff);
	}

//	// Auth
//	// return 200
//	@ResponseStatus(HttpStatus.OK)
//	@PostMapping("/auth")
//	LoginPojo authStaff(@RequestBody LoginPojo loginPojo) throws Exception {
//		// System.out.println(username+" --------------- "+pass);
//		// basic
//		// staffRepositoryServices.checkLogin(loginPojo);
//		// return loginPojo;
//
//		// token return
//		UsernamePasswordAuthenticationToken userpassword = new UsernamePasswordAuthenticationToken(
//				loginPojo.getUsername(), loginPojo.getPassword());
//		try {
//			authenticationManager.authenticate(userpassword);
//		} catch (DisabledException ex) {
//			throw new Exception("USER_DISABLED", ex);
//		} catch (BadCredentialsException ex) {
//			throw new Exception("INVALID_CREDENTIALS", ex);
//		}
//		final UserDetails userDetails = staffRepositoryServices.loadUserByUsername(loginPojo.getUsername());
//
//		final String token = jwtUtil.generateToken(userDetails);
//
//		loginPojo.setAccessToken(token);
//
//		return loginPojo;
//	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/auth")
	String authStaff(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password)
			throws Exception {
		UsernamePasswordAuthenticationToken userpassword = new UsernamePasswordAuthenticationToken(username, password);
		try {
			authenticationManager.authenticate(userpassword);
		} catch (DisabledException ex) {
			LOGGER.info(ex.getMessage());
			throw new Exception("USER_DISABLED", ex);
		} catch (BadCredentialsException ex) {
			LOGGER.info(ex.getMessage());
			throw new Exception("INVALID_CREDENTIALS", ex);
		} catch (AuthenticationException e) {
			LOGGER.info(e.getMessage());
			throw e;
		}
		final UserDetails userDetails = staffRepositoryServices.loadUserByUsername(username);

		final String token = jwtUtil.generateToken(userDetails);

		return token;
	}

	// return 200
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/changepass")
	public String changePass(@RequestBody ChangePassPojo loginPojo) {
		// System.out.println(username+" --------------- "+pass);
		return staffRepositoryServices.changePass(loginPojo);
	}

	// update or insert
	// return 200
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/resetPass")
	boolean resetPassWord(@RequestBody String idStaff) {
		staffRepositoryServices.resetPassword(idStaff);
		return true;
	}

	@ResponseStatus(HttpStatus.RESET_CONTENT)
	@PostMapping("/refreshToken")
	ResponseEntity<Map<String, String>> refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String tokenExists = WebUtil.extractJwtFromRequest(request);
		Map<String, String> dataSendToClient = new HashMap<String, String>();
		
// solution 1 return client is chain json by use repose write(byte[])
//		if(jwtUtil.isExpiredToken(request,tokenExists)) {
//			
//			// get claim from request , request was pushed from exception expried token
//			DefaultClaims claims = (DefaultClaims) request.getAttribute("claims");
//			
//			String token = jwtUtil.refreshToken(claims, claims.getSubject());
//			LOGGER.info( token);
//			dataSendToClient.put("token", token);
//			WebUtil.writeResponeToClent(dataSendToClient, HttpStatus.CREATED.value(), request, response);
//		}else {
//			
//			dataSendToClient.put("token", "not modified");
//			WebUtil.writeResponeToClent(dataSendToClient, 456789, request, response);
//		}
		
		
		//solution 2 return client is chain json by use ResponseEntity
		if (jwtUtil.isExpiredToken(request, tokenExists)) {

			// get claim from request , request was pushed from exception expried token
			DefaultClaims claims = (DefaultClaims) request.getAttribute("claims");

			String token = jwtUtil.refreshToken(claims, claims.getSubject());
			LOGGER.info(token);
			dataSendToClient.put("token", token);
			
			MultiValueMap<String,String> header = new HttpHeaders();
			header.set(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE);
			return new ResponseEntity<Map<String, String>>(dataSendToClient, header, HttpStatus.CREATED);
		} else {

			dataSendToClient.put("token", "not modified");
			dataSendToClient.put("token2", "not modified");
			dataSendToClient.put("token3", "not modified");
			dataSendToClient.put("token4", "not modified");
			
			MultiValueMap<String,String> header = new HttpHeaders();
			header.set(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE);
			return new ResponseEntity<Map<String, String>>(dataSendToClient, header, HttpStatus.UNAUTHORIZED);
		}

	}
}
