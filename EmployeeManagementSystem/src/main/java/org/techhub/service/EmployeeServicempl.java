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
	public List<EmployeeModel> showAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
