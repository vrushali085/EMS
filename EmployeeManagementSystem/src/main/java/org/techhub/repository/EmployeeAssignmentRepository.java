package org.techhub.repository;

import java.util.List;

public interface EmployeeAssignmentRepository {
	boolean isAssignRoleToEmployee(int employeeId, int roleId);
    List<Integer> getRolesForEmployee(int employeeId);
    boolean removeRoleFromEmployee(int employeeId, int roleId);
    boolean assignDepartmentToEmployee(int employeeId, int departmentId);
    List<Integer> getDepartmentsForEmployee(int employeeId);
    boolean removeDepartmentFromEmployee(int employeeId, int departmentId);

}
