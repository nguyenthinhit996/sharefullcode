package com.blogpost.sharefullcode.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blogpost.sharefullcode.model.UserModel;
import com.blogpost.sharefullcode.repo.UserRepository;

@Service
public class MyUserDetailServices implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;

	/*
	 * @PostConstruct public void completeSetup() { userRepository =
	 * applicationContext.getBean(UserRepository.class); }
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userRepository.findByusername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new AppUserPrincipal(user);		 
	}

}
