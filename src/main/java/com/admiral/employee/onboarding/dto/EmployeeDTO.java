package com.admiral.employee.onboarding.dto;


public class EmployeeDTO {
	
	private Long empID;
	
	private String employeeName;
	
	private String department;
	
	private Double salary;

	
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

	public long getEmpID() {
		return empID;
	}
	
	public void setEmpID(long id) {
		this.empID = id;
	}
	
	public EmployeeDTO() {
		super();
		this.employeeName = null;
		this.department = null;
		this.salary = null;
	}

	public EmployeeDTO(String employeeName, String department, Double salary) {
		super();
		this.employeeName = employeeName;
		this.department = department;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [ empID=" + empID + ", employeeName=" + employeeName + ", department="
				+ department + ", salary=" + salary + "]";
	}


}
