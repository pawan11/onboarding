package com.admiral.employee.onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admiral.employee.onboarding.dto.EmployeeDTO;
import com.admiral.employee.onboarding.exception.InvalidInputDataException;
import com.admiral.employee.onboarding.exception.ResourceNotFoundException;
import com.admiral.employee.onboarding.service.OnboardingService;


@RequestMapping("/v1/onboarding")
@RestController
public class OnboardingEmployeeController {

	@Autowired
	OnboardingService service;
	
	@GetMapping("/emp") 
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() throws ResourceNotFoundException,Exception{
		List<EmployeeDTO> allEmpList = service.getAllEmployees();
		return new ResponseEntity<List<EmployeeDTO>>(allEmpList, HttpStatus.OK);
	}
	
	@GetMapping("/empDetail")
	public ResponseEntity<EmployeeDTO> getEmployeeDetails(@RequestParam("empID") Long employeeId) throws Exception{
		if(employeeId == 0) throw new InvalidInputDataException("Employee Id is not correct");
		EmployeeDTO empDetail = service.getEmployeeDetails(employeeId);
		return new ResponseEntity<EmployeeDTO>(empDetail, HttpStatus.OK);
	}
	
	@PostMapping("/emp")
	public ResponseEntity<String> onboardEmployee(@RequestBody EmployeeDTO emp) throws Exception{
		System.out.println(emp.toString());
		if(emp.getEmployeeName().isBlank() || emp.getEmployeeName().isEmpty()) throw new InvalidInputDataException("Employee Name is mandatory");
		Long empID = service.onboardEmployee(emp);
		return new ResponseEntity<String>("Employee is onboarded with employee ID : "+empID, HttpStatus.OK);
	}
	
	@PutMapping("/emp")
	public ResponseEntity<Long> updateEmployee(@RequestBody EmployeeDTO emp) throws Exception{
		if(emp.getEmpID() == 0) throw new InvalidInputDataException("Employee Id is not correct");
		return new ResponseEntity<Long>(service.updateEmployee(emp), HttpStatus.OK);
	}
	
	@DeleteMapping("/emp/{empID}")
	public ResponseEntity<String> deleteEmployeeDetails(@PathVariable("empID") Long employeeId) throws Exception{
		if(employeeId == 0) throw new InvalidInputDataException("Employee Id is not correct");
		service.deleteEmployee(employeeId);
		return new ResponseEntity<String>("Employee is successfuly deleted", HttpStatus.ACCEPTED);
	}
}
