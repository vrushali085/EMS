package org.techhub.service;

import java.util.List;

import org.techhub.model.EmployeeModel;

public interface EmployeeService {
	
	public boolean isAddNewEmp(EmployeeModel model);

	public List<EmployeeModel> showAllEmployees();

}
