package com.admiral.employee.onboarding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admiral.employee.onboarding.dto.AuthRequest;
import com.admiral.employee.onboarding.entity.UserInfo;
import com.admiral.employee.onboarding.service.JwtService;
import com.admiral.employee.onboarding.service.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping("/echo")
	public String echo() {
		return "Echo";
	}
	
	@PostMapping("/generateToken")
//	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws Exception{
		//TODO: process POST request
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUsername());
		}else {
			throw new UsernameNotFoundException("Invalid User request");
		}
	}
	
	@PostMapping("/addNewUser")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		//TODO: process POST request
		return userInfoService.addUser(userInfo);
	}
	
	
}
