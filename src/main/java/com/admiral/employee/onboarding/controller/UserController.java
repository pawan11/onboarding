package com.admiral.employee.onboarding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admiral.employee.onboarding.dto.AuthRequest;
import com.admiral.employee.onboarding.entity.UserInfo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class UserController {

	
	@PostMapping("/generateToken")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		//TODO: process POST request
		
		return null;
	}
	
	@PostMapping("/addNewUser")
	public String postMethodName(@RequestBody UserInfo userInfo) {
		//TODO: process POST request
		
		return null;
	}
	
	
}
