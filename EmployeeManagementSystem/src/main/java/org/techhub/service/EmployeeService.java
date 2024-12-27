package org.techhub.service;

import java.util.List;

import org.techhub.model.EmployeeModel;

public interface EmployeeService {
	
	public boolean isAddNewEmp(EmployeeModel model);

	public List<EmployeeModel> showAllEmployee();
	public List<EmployeeModel> getEmployeesByName(String name) ;
	public boolean deleteEmployeeByName(String name);
	public boolean updateEmployeeByName(String newName, int age, String gender, int salary, String oldName);
	public EmployeeModel getEmployeeDetailsById(int empId);

}
