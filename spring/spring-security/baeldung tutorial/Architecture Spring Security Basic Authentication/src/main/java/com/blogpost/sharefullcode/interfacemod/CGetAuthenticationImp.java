package com.blogpost.sharefullcode.interfacemod;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CGetAuthenticationImp implements IGetAuthentication{

	@Override
	public String inforAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
