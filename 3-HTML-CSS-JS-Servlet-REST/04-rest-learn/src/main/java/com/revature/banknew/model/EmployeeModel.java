package com.revature.banknew.model;

public class EmployeeModel {
	private int employeeId;
	private String name;
	private String email;
	private String password;
	private String department;
	public EmployeeModel() {
		super();
	}
	
	public EmployeeModel(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public EmployeeModel(int employeeId, String name, String email, String password, String department) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.department = department;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmployeeModel [employeeId=" + employeeId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", department=" + department + "]";
	}
	

}
