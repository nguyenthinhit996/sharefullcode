package com.blogpost.sharefullcode.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogpost.sharefullcode.interfacemod.IGetAuthentication;

@Controller
public class ControllerGetAuthentication {

	@Autowired
	IGetAuthentication CGetAuthenticationImp;
	
	@RequestMapping(value = "/user/static")
	@ResponseBody
	String getByStaticSecurityContextHolder() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    return currentUserName;
		}
		return "AnonymousAuthenticationToken User";
	}
	
	@RequestMapping(value="/user/principal")
	@ResponseBody
	String getByPrincial(Principal principal) {
		return principal.getName();
	}
	
	@RequestMapping(value="/user/au")
	@ResponseBody
	String getByau(Authentication authentication) {
		return authentication.getName();
	}
	
	@RequestMapping(value="/user/http")
	@ResponseBody
	String getByHttp(HttpServletRequest request) {
		return request.getUserPrincipal().getName();
	}
	
	@RequestMapping(value="/user/byInterface")
	@ResponseBody
	String byInterface(HttpServletRequest request) {
		return CGetAuthenticationImp.inforAuthentication();
	}
	
	@RequestMapping(value="/user/jspview")
	 
	String jspview(HttpServletRequest request) {
		return "viewauthen";
	}
}
