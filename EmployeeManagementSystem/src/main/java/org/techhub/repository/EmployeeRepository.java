package org.techhub.repository;

import java.util.List;

import org.techhub.model.EmployeeModel;

public interface EmployeeRepository {
	public boolean isAddNewEmp(EmployeeModel model);
    public List<EmployeeModel> showAllEmployee();
    public List<EmployeeModel> getEmployeesByName(String name);
    public boolean deleteEmployeeByName(String name);
    public boolean updateEmployeeByName(String newName, int age, String gender, int salary, String oldName);
}
