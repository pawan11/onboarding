package com.admiral.employee.onboarding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admiral.employee.onboarding.dto.AuthRequest;
import com.admiral.employee.onboarding.entity.UserInfo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class UserController {

	
	@GetMapping("/echo")
	public String echo() {
		return "Echo";
	}
	
	@PostMapping("/generateToken")
//	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		//TODO: process POST request
		
		return null;
	}
	
	@PostMapping("/addNewUser")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String postMethodName(@RequestBody UserInfo userInfo) {
		//TODO: process POST request
		
		return null;
	}
	
	
}
