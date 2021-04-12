package com.blogpost.sharefullcode;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class MyLoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	Log logger = LogFactory.getLog(this.getClass());	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		handler(request,response,authentication);
		clearAuthenticationAttributes(request);
		
	}

	protected void handler(HttpServletRequest request,
	        HttpServletResponse response, 
	        Authentication authentication) throws IOException {
		String url = determineTargerURL(authentication);
		if (response.isCommitted()) {
	        logger.debug(
	                "Response has already been committed. Unable to redirect to "
	                        + url);
	        return;
	    }
		redirectStrategy.sendRedirect(request, response, url);
	}
	
	String determineTargerURL(Authentication authen) {
		Map<String, String> mapRedirect = new HashMap<String, String>();
		mapRedirect.put("ROLE_ADMIN", "/admin");
		mapRedirect.put("ROLE_USER", "/user");
		
		final Collection<? extends GrantedAuthority> lsAuthority = authen.getAuthorities();
		
		for(GrantedAuthority in : lsAuthority) {
			String authorityName = in.getAuthority();
			if(mapRedirect.containsKey(authorityName)) {
				return mapRedirect.get(authorityName);
			}
		}
		throw new IllegalStateException();
	}
	
	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		
	}
}
