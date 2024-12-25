package org.techhub.model;

public class EmployeeModel {
	private int employee_id;
	private String employeename;
	private int age;
	private String gender;
	private int salary;
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public EmployeeModel(int employee_id, String employeename, int age, String gender, int salary) {
		super();
		this.employee_id = employee_id;
		this.employeename = employeename;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}
	
	public EmployeeModel()
	{
		
	}
	
	

}
