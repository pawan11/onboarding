package com.admiral.employee.onboarding.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "customerActuator")
public class CustomerActuator {

	@ReadOperation
	public String testCustomActuator() {
		return "Hello World";
	}
}
