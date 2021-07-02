package com.blogpost.sharefullcode.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.blogpost.sharefullcode.model.UserModel;

@Service
public class AppUserPrincipal implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7133966550392951758L;
	private UserModel userModel;
	
	AppUserPrincipal() {
		super();
	}
	
	public AppUserPrincipal(UserModel userModel) {
		this.userModel = userModel;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 String [] arrayGrant = this.userModel.getRole().split(",");
		 List<GrantedAuthority> ls = new ArrayList<GrantedAuthority>();
		 for(String in : arrayGrant) {
			 SimpleGrantedAuthority simple = new SimpleGrantedAuthority(in);
			 ls.add(simple);
		 }
		 System.out.println(ls);
		 return ls;
	}

	@Override
	public String getPassword() {
		return this.userModel.getPassword();
	}

	@Override
	public String getUsername() {
		return this.userModel.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
