package com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.MyUser;
import com.javainuse.repo.UserRepo;

@RestController
@CrossOrigin()
public class HelloWorldController {
	@Autowired
	private UserRepo repo;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping({ "/hello" })
	public String hello() {
		return "Hello World";
	}
	
	@PostMapping("/user")
	public String createUser(@RequestBody MyUser user) {
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		return "User Added Successfully";
	}

}
