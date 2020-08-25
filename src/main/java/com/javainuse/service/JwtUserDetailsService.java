package com.javainuse.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javainuse.model.MyCustomUser;
import com.javainuse.model.MyUser;
import com.javainuse.repo.UserRepo;

@Service

public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepo urepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if ("javainuse".equals(username)) {
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
		
		MyUser cuser = urepo.findByUserName(username);
		
		return new User(cuser.getName(),cuser.getPassword(),
					new ArrayList<>());
	}

	

}