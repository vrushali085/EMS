package org.techhub.service;

import java.util.List;
import org.techhub.repository.EmployeeAssignmentRepository;
import org.techhub.repository.EmployeeAssignmentRepositoryImpl;

public class EmployeeAssignmentServiceImpl implements EmployeeAssignmentService {

    EmployeeAssignmentRepository repository = new EmployeeAssignmentRepositoryImpl();

    // Assign role by employeeId and role_id
    @Override
    public boolean assignRoleToEmployee(int employeeId, int roleId) {
        return repository.assignRoleToEmployee(employeeId, roleId);
    }

    

    // Get roles for an employee by their name
    @Override
    public List<String> getRolesForEmployee(String employeeName) {
        return repository.getRolesForEmployee(employeeName);
    }

    // Assign department to employee by name
    @Override
    public boolean assignDepartmentToEmployeeByName(String employeeName, int departmentId) {
        return repository.assignDepartmentToEmployeeByName(employeeName, departmentId);
    }



	@Override
	public boolean removeRoleFromEmployee(String employeeName, String roleName) {
		// TODO Auto-generated method stub
		return repository.removeDepartmentFromEmployee(employeeName, roleName);
	}



	@Override
	public List<String> getDepartmentsForEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return repository.getDepartmentsForEmployee(employeeId);
	}



	@Override
	public boolean removeDepartmentFromEmployee(String employeeName, String departmentName) {
		// TODO Auto-generated method stub
		return repository.removeDepartmentFromEmployee(employeeName, departmentName);
	}



	
}
