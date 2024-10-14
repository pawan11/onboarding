package com.admiral.employee.onboarding.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admiral.employee.onboarding.dto.EmployeeDTO;
import com.admiral.employee.onboarding.entity.EmployeeEntity;
import com.admiral.employee.onboarding.exception.ResourceNotFoundException;
import com.admiral.employee.onboarding.repository.EmployeeRepository;

@Service
public class OnboardingService {

	
	@Autowired
	EmployeeRepository empRepo;
	
	//ModelMapper 
	public List<EmployeeDTO> getAllEmployees() throws Exception{
		Optional<List<EmployeeEntity>> empEntityList = Optional.ofNullable(empRepo.findAll());
		
		if(!empEntityList.isPresent()) throw new ResourceNotFoundException("No Employee Data Present");
		
		List<EmployeeDTO> empDTOList = new ArrayList<EmployeeDTO>();
		
		empEntityList.get().forEach(emp -> {
			System.out.println(emp.toString());
			EmployeeDTO empDTO = new EmployeeDTO();
			empDTO.setEmpID(emp.getEmpID());
			empDTO.setDepartment(emp.getDepartment());
			empDTO.setEmployeeName(emp.getEmployeeName());
			empDTO.setSalary(emp.getSalary());
			empDTOList.add(empDTO);
		});
		
		return empDTOList;
	}
	
	public EmployeeDTO getEmployeeDetails(long empID) throws Exception {
		Optional<EmployeeEntity> empEntity = empRepo.findById(empID);
		
		if(empEntity.isEmpty()) new ResourceNotFoundException("Employee with ID:"+empID+" is not present in Data");
		System.out.println(empEntity.toString());
		EmployeeDTO empDTO = new EmployeeDTO();
		empDTO.setEmpID(empEntity.get().getEmpID());
		empDTO.setDepartment(empEntity.get().getDepartment());
		empDTO.setEmployeeName(empEntity.get().getEmployeeName());
		empDTO.setSalary(empEntity.get().getSalary());
		
		return empDTO;
	}
	
	public Long onboardEmployee(EmployeeDTO empDTO) {
		
		EmployeeEntity empEntity = new EmployeeEntity(empDTO.getEmployeeName(), empDTO.getDepartment(), empDTO.getSalary());
		
		empEntity = empRepo.save(empEntity);
		System.out.println(empEntity.toString());
		return empEntity.getEmpID();
	}
	
	public Long updateEmployee(EmployeeDTO empDTO) throws Exception{
		Optional<EmployeeEntity> existingEmpEntity = empRepo.findById(empDTO.getEmpID());
		
		if(existingEmpEntity.isEmpty()) new ResourceNotFoundException("Employee with ID:"+empDTO.getEmpID()+" is not present in Data");
		
		existingEmpEntity.get().setEmployeeName(empDTO.getEmployeeName());
		existingEmpEntity.get().setDepartment(empDTO.getDepartment());
		existingEmpEntity.get().setSalary(empDTO.getSalary());
		
		EmployeeEntity emp = empRepo.save(existingEmpEntity.get());
		
		return emp.getEmpID();
	}
	
	public void deleteEmployee(long empID) throws Exception {
		
		Optional<EmployeeEntity> existingEmpEntity = empRepo.findById(empID);
		
		if(existingEmpEntity.isEmpty()) new ResourceNotFoundException("Employee with ID:"+empID+" is not present in Data");
		
		empRepo.delete(existingEmpEntity.get());
	}
}
