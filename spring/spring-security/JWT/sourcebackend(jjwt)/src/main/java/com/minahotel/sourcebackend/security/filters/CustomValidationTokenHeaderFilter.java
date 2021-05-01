package com.minahotel.sourcebackend.security.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.minahotel.sourcebackend.common.WebUtil;
import com.minahotel.sourcebackend.security.JwtUtil;

@Component
public class CustomValidationTokenHeaderFilter extends OncePerRequestFilter {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass().toString());

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (!"/refreshToken".equalsIgnoreCase(request.getServletPath())) {
			String tokenExists = WebUtil.extractJwtFromRequest(request);
			if (StringUtils.hasText(tokenExists) && jwtTokenUtil.validatationToken(tokenExists)) {
				List<GrantedAuthority> lsAuthorization = jwtTokenUtil.getRolesFromToken(tokenExists);
				UserDetails userDetails = new User(jwtTokenUtil.getIdStaffFromToken(tokenExists), "", lsAuthorization);
				UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(userDetails, null,
						userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(user);
			} else {
				LOGGER.info("Not token in header ");
			}
		}
		// continue filter of chain
		filterChain.doFilter(request, response);
	}

	
}
