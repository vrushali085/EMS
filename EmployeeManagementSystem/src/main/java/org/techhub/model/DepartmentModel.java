package org.techhub.model;

public class DepartmentModel {
	private int department_id;
	private String name;
	private String location;
	public DepartmentModel(int department_id, String name, String location) {
		super();
		this.department_id = department_id;
		this.name = name;
		this.location = location;
	}
	public DepartmentModel()
	{
		
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
