package org.techhub.repository;

import java.util.List;

public interface EmployeeAssignmentRepository {
	public boolean assignRoleToEmployee(int employeeId, int role_id);
    List<String> getRolesForEmployee(String employeeName);
    boolean removeRoleFromEmployee(String employeeName, String roleName);  // Keep only this version
    boolean assignDepartmentToEmployeeByName(String employeeName, int departmentId); // You should implement this or remove it if not needed
    public List<String> getDepartmentsForEmployee(int employeeId);
    public boolean removeDepartmentFromEmployee(String employeeName, String departmentName);
}
