package com.blogpost.sharefullcode.handler;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	private RedirectStrategy redirect = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		determineRedirectLink(request, response, authentication);
		clearAuthenticationAttributes(request);
	}
	
	void determineRedirectLink(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		Map<String,String> roleWithRedirect = new HashMap<String,String>();
		roleWithRedirect.put("ROLE_USER", "/user");
		roleWithRedirect.put("ROLE_ADMIN", "/admin");
		List<? extends GrantedAuthority> lsAuthori = (List<? extends GrantedAuthority>) authentication.getAuthorities();
		if(roleWithRedirect.containsKey(lsAuthori.get(0).getAuthority())){
			System.out.println(roleWithRedirect.get(lsAuthori.get(0).getAuthority()));
			redirect.sendRedirect(request, response, roleWithRedirect.get(lsAuthori.get(0).getAuthority()));
		}
	}

	void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session ==  null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
}
