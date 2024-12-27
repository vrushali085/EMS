package org.techhub.repository;

import java.util.List;

public interface EmployeeAssignmentRepository {
	boolean isAssignRoleToEmployee(int employeeId, int roleId);
    List<Integer> getRolesForEmployee(int employeeId);
    boolean removeRoleFromEmployee(int employeeId, int roleId);
    boolean assignDepartmentToEmployee(int employeeId, int departmentId);
    List<String> getDepartmentNamesForEmployee(int employeeId);
    boolean removeDepartmentFromEmployee(int employeeId, int departmentId);
    public List<String> getRoleNamesForEmployee(int employeeId);
    public boolean updateRoleForEmployee(int employeeId, String oldRoleName, String newRoleName);
    public boolean updateDepartmentForEmployee(int employeeId, String currentDepartmentName, String newDepartmentName);

}
