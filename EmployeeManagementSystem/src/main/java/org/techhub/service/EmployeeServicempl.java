package org.techhub.service;

import java.util.List;

import org.techhub.model.EmployeeModel;
import org.techhub.repository.EmployeeRepository;
import org.techhub.repository.EmployeeRepositoryImpl;

public class EmployeeServicempl implements EmployeeService {

	EmployeeRepository empRepo = new EmployeeRepositoryImpl();

	@Override
	public boolean isAddNewEmp(EmployeeModel model) {
		
		return empRepo.isAddNewEmp(model);
	}

	@Override
	public List<EmployeeModel> showAllEmployee() {
		
		return empRepo.showAllEmployee();
	}

	@Override
	public List<EmployeeModel> getEmployeesByName(String name) {
		
		return empRepo.getEmployeesByName(name);
	}

	@Override
	public boolean deleteEmployeeByName(String name) {
		
		return empRepo.deleteEmployeeByName(name);
	}

	@Override
	public boolean updateEmployeeByName(String newName, int age, String gender, int salary, String oldName) {
		
		return empRepo.updateEmployeeByName(newName, age, gender, salary, oldName);
	}
	
	
	}


