package org.techhub.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAssignmentRepositoryImpl extends DBSTATE implements EmployeeAssignmentRepository {

    @Override
    public boolean isAssignRoleToEmployee(int employeeId, int roleId) {
        try {
            stmt = conn.prepareStatement("INSERT INTO employee_role (employee_id, role_id) VALUES (?, ?)");
            stmt.setInt(1, employeeId);
            stmt.setInt(2, roleId);

            int value = stmt.executeUpdate();
            if (value > 0) {
                return true; // Role assignment successful
            } else {
                return false; // Failed to assign role
            }
        } catch (SQLException ex) {
            System.out.println("Error while assigning role: " + ex);
        }
        return false;
    }

    // Get Roles for an Employee
    @Override
    public List<Integer> getRolesForEmployee(int employeeId) {
        List<Integer> roles = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT role_id FROM employee_role WHERE employee_id = ?");
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                roles.add(rs.getInt("role_id"));
            }
        } catch (SQLException ex) {
            System.out.println("Error while fetching roles: " + ex);
        }
        return roles;
    }

    // Remove Role from Employee
    @Override
    public boolean removeRoleFromEmployee(int employeeId, int roleId) {
        try {
            stmt = conn.prepareStatement("DELETE FROM employee_role WHERE employee_id = ? AND role_id = ?");
            stmt.setInt(1, employeeId);
            stmt.setInt(2, roleId);

            int value = stmt.executeUpdate();
            if (value > 0) {
                return true; // Role removed successfully
            } else {
                return false; // Failed to remove role
            }
        } catch (SQLException ex) {
            System.out.println("Error while removing role: " + ex);
        }
        return false;
    }

    // Assign Department to Employee
    @Override
    public boolean assignDepartmentToEmployee(int employeeId, int departmentId) {
        try {
            stmt = conn.prepareStatement("INSERT INTO employee_department (employee_id, department_id) VALUES (?, ?)");
            stmt.setInt(1, employeeId);
            stmt.setInt(2, departmentId);

            int value = stmt.executeUpdate();
            if (value > 0) {
                return true; // Department assignment successful
            } else {
                return false; // Failed to assign department
            }
        } catch (SQLException ex) {
            System.out.println("Error while assigning department: " + ex);
        }
        return false;
    }

    // Get Departments for an Employee
    @Override
    public List<Integer> getDepartmentsForEmployee(int employeeId) {
        List<Integer> departments = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT department_id FROM employee_department WHERE employee_id = ?");
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                departments.add(rs.getInt("department_id"));
            }
        } catch (SQLException ex) {
            System.out.println("Error while fetching departments: " + ex);
        }
        return departments;
    }

    // Remove Department from Employee
    @Override
    public boolean removeDepartmentFromEmployee(int employeeId, int departmentId) {
        try {
            stmt = conn.prepareStatement("DELETE FROM employee_department WHERE employee_id = ? AND department_id = ?");
            stmt.setInt(1, employeeId);
            stmt.setInt(2, departmentId);

            int value = stmt.executeUpdate();
            if (value > 0) {
                return true; // Department removed successfully
            } else {
                return false; // Failed to remove department
            }
        } catch (SQLException ex) {
            System.out.println("Error while removing department: " + ex);
        }
        return false;
    }
}
