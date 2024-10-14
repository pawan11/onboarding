package com.admiral.employee.onboarding.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empID;
	
	@Column(name = "employeename" , nullable = false)
	private String employeeName;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "salary")
	private Double salary;
	
	@Column(name = "created")
	private Date created;
	

	public long getEmpID() {
		return empID;
	}

	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getCreated() {
		return created;
	}


	public EmployeeEntity() {
		super();
		this.employeeName = null;
		this.department = null;
		this.salary = null;
		this.created = null;
	}

	public EmployeeEntity(String employeeName, String department, Double salary) {
		super();
		this.employeeName = employeeName;
		this.department = department;
		this.salary = salary;
		this.created = new Date();	
	}

	@Override
	public String toString() {
		return "EmployeeEntity [empID=" + empID + ", employeeName=" + employeeName + ", department=" + department
				+ ", salary=" + salary + ", created=" + created + "]";
	}
	
	
		
}
