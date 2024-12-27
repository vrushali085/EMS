package org.techhub.service;

import org.techhub.repository.EmployeeAssignmentRepository;
import org.techhub.repository.EmployeeAssignmentRepositoryImpl;
import java.util.List;

public class EmployeeAssignmentServiceImpl implements EmployeeAssignmentService {

    // Instantiating the repository implementation
    EmployeeAssignmentRepository empRepo = new EmployeeAssignmentRepositoryImpl();

    @Override
    public boolean assignRoleToEmployee(int employeeId, int roleId) {
        return empRepo.isAssignRoleToEmployee(employeeId, roleId);
    }

    @Override
    public List<Integer> getRolesForEmployee(int employeeId) {
        return empRepo.getRolesForEmployee(employeeId);
    }

    @Override
    public List<String> getRoleNamesForEmployee(int employeeId) {
        return empRepo.getRoleNamesForEmployee(employeeId);
    }

    @Override
    public boolean removeRoleFromEmployee(int employeeId, int roleId) {
        return empRepo.removeRoleFromEmployee(employeeId, roleId);
    }

    @Override
    public boolean assignDepartmentToEmployee(int employeeId, int departmentId) {
        return empRepo.assignDepartmentToEmployee(employeeId, departmentId);
    }

    @Override
    public List<String> getDepartmentNamesForEmployee(int employeeId) {
        return empRepo.getDepartmentNamesForEmployee(employeeId);
    }

    @Override
    public boolean removeDepartmentFromEmployee(int employeeId, int departmentId) {
        return empRepo.removeDepartmentFromEmployee(employeeId, departmentId);
    }

    @Override
    public boolean updateRoleForEmployee(int employeeId, String oldRoleName, String newRoleName) {
        return empRepo.updateRoleForEmployee(employeeId, oldRoleName, newRoleName);
    }
    @Override
    public boolean updateDepartmentForEmployee(int employeeId, String currentDepartmentName, String newDepartmentName) {
        // Delegates the department update request to the repository
        return empRepo.updateDepartmentForEmployee(employeeId, currentDepartmentName, newDepartmentName);
    }

}
