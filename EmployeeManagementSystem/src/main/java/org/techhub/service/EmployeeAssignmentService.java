package org.techhub.service;

import java.util.List;

public interface EmployeeAssignmentService {
	 boolean assignRoleToEmployee(int employeeId, int roleid);

	    // Method to get the list of roles assigned to an employee
	 public List<String> getRolesForEmployee(String employeeName);

	    // Method to remove a specific role from an employee
	 public boolean removeRoleFromEmployee(String employeeName, String roleName);

	    // Method to assign a department to an employee
	 public boolean assignDepartmentToEmployeeByName(String employeeName, int departmentId);

	    // Method to get the list of departments assigned to an employee
	 public List<String> getDepartmentsForEmployee(int employeeId);
//
//	    // Method to remove a specific department from an employee
	 public boolean removeDepartmentFromEmployee(String employeeName, String departmentName);

}
