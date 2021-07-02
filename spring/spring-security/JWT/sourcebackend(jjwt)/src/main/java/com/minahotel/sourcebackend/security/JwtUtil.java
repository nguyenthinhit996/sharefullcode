package com.minahotel.sourcebackend.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {
	
	 Logger LOGGER = LoggerFactory.getLogger(this.getClass().toString());

	private String secret;
	private long jwtExpirationInMs;

	@Value("${jwt.secret}")
	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Value("${jwt.expirationDateInMs}")
	public void setJwtExpirationInMs(int jwtExpirationInMs) {
		this.jwtExpirationInMs = jwtExpirationInMs;
	}

	public String generateToken(UserDetails user) {
		Map<String, Object> claims = new HashMap<>();
		List<? extends GrantedAuthority> roles = user.getAuthorities() != null
				? new ArrayList<GrantedAuthority>(user.getAuthorities())
				: new ArrayList<GrantedAuthority>();
		roles.forEach(role -> {
			claims.put(role.getAuthority(), Boolean.TRUE);
		});
		String token = doGenarateToken(claims, user.getUsername());
		LOGGER.info(token);
		return token;
	}

	private String doGenarateToken(Map<String, Object> claims, String subject) {
 
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public boolean validatationToken(String token) {
		try {
			Jws<Claims> clainms = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			LOGGER.info(clainms.getBody().getSubject());
			return true;

		} catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
			throw new BadCredentialsException("INVALID_CREDENTIALS", ex);
		} catch (ExpiredJwtException ex) {
			throw new ExpiredJwtException(null, null, "Token has Expired");
		}

	}
	
	public Map<String,Object> getClaimsFromToken(String token){
		return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
	}
	
	 public boolean isExpiredToken(HttpServletRequest request, String token) {
		 try {
				Jws<Claims> clainms = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
				LOGGER.info(clainms.getBody().getSubject());
				return false;
			} catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
				return false;
			} catch (ExpiredJwtException ex) {
				
				//get claim from exception expired jwt
				request.setAttribute("claims", ex.getClaims());
				return true;
			}
	 }

	public String getIdStaffFromToken(String token) {
		return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody().getSubject();
	}

	public  List<GrantedAuthority> getRolesFromToken(String token) {
		List<GrantedAuthority> roles = null;
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		Boolean isAdmin = claims.get("admin", Boolean.class);
		Boolean isUsertieptan = claims.get("tieptan", Boolean.class);
		Boolean isUserdichvu = claims.get("dichvu", Boolean.class);
		if (isAdmin != null && isAdmin == true) {
			roles = AuthorityUtils.createAuthorityList("admin");
		}
		if (isUsertieptan != null && isUsertieptan == true) {
			roles = AuthorityUtils.createAuthorityList("tieptan");
		}
		if (isUserdichvu != null && isUserdichvu == true) {
			roles = AuthorityUtils.createAuthorityList("dichvu");
		}
		return roles;
	}

	public String refreshToken(Map<String,Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+jwtExpirationInMs)).signWith(SignatureAlgorithm.HS384, this.secret).compact();
	}
	
}
