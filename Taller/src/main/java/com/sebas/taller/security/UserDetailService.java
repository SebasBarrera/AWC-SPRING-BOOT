package com.sebas.taller.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sebas.taller.model.Users;
import com.sebas.taller.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	UserRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users userApp = null;
		
		List<Users> user = ur.findByUsername(username);
		
		if (user.size() != 0) {
			userApp = user.get(0);
			
			org.springframework.security.core.userdetails.User.UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username).password(userApp.getPassword()).roles(String.valueOf(userApp.getType()));
			return builder.build();
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
	}
}
