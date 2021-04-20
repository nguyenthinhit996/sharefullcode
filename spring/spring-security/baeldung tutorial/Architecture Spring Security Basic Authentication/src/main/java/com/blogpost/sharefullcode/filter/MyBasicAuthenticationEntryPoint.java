package com.blogpost.sharefullcode.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class MyBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint{
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		
		response.addHeader("WWW-Authenticate", "Basic realm=\"" + super.getRealmName() + "\"");
//		response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - " + authException.getMessage());
	}
	
	
	@Override
	public void afterPropertiesSet() {
		 setRealmName("Basic app");
		 super.afterPropertiesSet();
	}
}
