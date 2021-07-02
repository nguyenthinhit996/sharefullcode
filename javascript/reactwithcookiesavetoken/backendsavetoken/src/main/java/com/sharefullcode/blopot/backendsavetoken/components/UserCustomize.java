package com.sharefullcode.blopot.backendsavetoken.components;

import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * UserCustomize is object json communication client and server
 * @author Peter
 *
 */
public class UserCustomize extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7294795302903143155L;
	private String idStaff;
	
	public String getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(String idStaff) {
		this.idStaff = idStaff;
	}
	 
	public UserCustomize(String idStaff, String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
		this.idStaff = idStaff;
	}
	 
	public String parseCollectionGrantedAuthorizationToString() {
		List<GrantedAuthority>  ls = List.copyOf(this.getAuthorities());
		StringJoiner builder = new StringJoiner(",");
		for(GrantedAuthority el : ls) {
			builder.add(el.getAuthority());
		}
		return builder.toString();
	}
	
}
