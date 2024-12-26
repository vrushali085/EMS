package org.techhub.service;

import java.util.List;

public interface EmployeeAssignmentService {
	 boolean assignRoleToEmployee(int employeeId, int roleId);

	    // Method to get the list of roles assigned to an employee
	    List<Integer> getRolesForEmployee(int employeeId);

	    // Method to remove a specific role from an employee
	    boolean removeRoleFromEmployee(int employeeId, int roleId);

	    // Method to assign a department to an employee
	    boolean assignDepartmentToEmployee(int employeeId, int departmentId);

	    // Method to get the list of departments assigned to an employee
	    List<Integer> getDepartmentsForEmployee(int employeeId);

	    // Method to remove a specific department from an employee
	    boolean removeDepartmentFromEmployee(int employeeId, int departmentId);

}
