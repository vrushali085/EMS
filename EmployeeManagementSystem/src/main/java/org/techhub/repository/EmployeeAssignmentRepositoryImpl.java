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
            return value > 0?true:false;
        } catch (SQLException ex) {
            System.out.println("Error while assigning role: " + ex);
        }
        return false;
    }

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

    @Override
    public boolean removeRoleFromEmployee(int employeeId, int roleId) {
        try {
            stmt = conn.prepareStatement("DELETE FROM employee_role WHERE employee_id = ? AND role_id = ?");
            stmt.setInt(1, employeeId);
            stmt.setInt(2, roleId);
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (SQLException ex) {
            System.out.println("Error while removing role: " + ex);
        }
        return false;
    }

    @Override
    public boolean assignDepartmentToEmployee(int employeeId, int departmentId) {
        try {
            stmt = conn.prepareStatement("INSERT INTO employee_department (employee_id, department_id) VALUES (?, ?)");
            stmt.setInt(1, employeeId);
            stmt.setInt(2, departmentId);
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (SQLException ex) {
            System.out.println("Error while assigning department: " + ex);
        }
        return false;
    }

    @Override
    public List<String> getDepartmentNamesForEmployee(int employeeId) {
        List<String> departmentNames = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT d.name FROM employee_department ed JOIN department d ON ed.department_id = d.department_id WHERE ed.employee_id = ?");
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                departmentNames.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
            System.out.println("Error while fetching department names: " + ex.getMessage());
        }
        return departmentNames;
    }

    @Override
    public boolean removeDepartmentFromEmployee(int employeeId, int departmentId) {
        try {
            stmt = conn.prepareStatement("DELETE FROM employee_department WHERE employee_id = ? AND department_id = ?");
            stmt.setInt(1, employeeId);
            stmt.setInt(2, departmentId);
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (SQLException ex) {
            System.out.println("Error while removing department: " + ex);
        }
        return false;
    }

    @Override
    public List<String> getRoleNamesForEmployee(int employeeId) {
        List<String> roleNames = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT r.role_name FROM employee_role er JOIN roles r ON er.role_id = r.role_id WHERE er.employee_id = ?");
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                roleNames.add(rs.getString("role_name"));
            }
        } catch (SQLException ex) {
            System.out.println("Error while fetching role names: " + ex.getMessage());
        }
        return roleNames;
    }

    @Override
    public boolean updateRoleForEmployee(int employeeId, String oldRoleName, String newRoleName) {
        try {
            // Get old and new role IDs
            int oldRoleId = getRoleIdByName(oldRoleName);
            int newRoleId = getRoleIdByName(newRoleName);

            if (oldRoleId == -1 || newRoleId == -1) {
                System.out.println("One or both role names not found.");
                return false;
            }

            // Update role in the database
            stmt = conn.prepareStatement("UPDATE employee_role SET role_id = ? WHERE employee_id = ? AND role_id = ?");
            stmt.setInt(1, newRoleId); // Set new role ID
            stmt.setInt(2, employeeId); // Set employee ID
            stmt.setInt(3, oldRoleId); // Set old role ID
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            System.out.println("Error while updating role: " + ex.getMessage());
        }
        return false;
    }
    @Override
    public boolean updateDepartmentForEmployee(int employeeId, String currentDepartmentName, String newDepartmentName) {
        try {
            // Step 1: Get the department ID for the current department name
            stmt = conn.prepareStatement(
                "SELECT department_id FROM departments WHERE department_name = ?"
            );
            stmt.setString(1, currentDepartmentName);
            ResultSet rs = stmt.executeQuery();

            int currentDepartmentId = -1;
            if (rs.next()) {
                currentDepartmentId = rs.getInt("department_id");
            }

            if (currentDepartmentId == -1) {
                return false; // Current department doesn't exist
            }

            // Step 2: Get the department ID for the new department name
            stmt = conn.prepareStatement(
                "SELECT department_id FROM departments WHERE department_name = ?"
            );
            stmt.setString(1, newDepartmentName);
            rs = stmt.executeQuery();

            int newDepartmentId = -1;
            if (rs.next()) {
                newDepartmentId = rs.getInt("department_id");
            }

            if (newDepartmentId == -1) {
                return false; // New department doesn't exist
            }

            // Step 3: Remove the old department from employee
            stmt = conn.prepareStatement(
                "DELETE FROM employee_department WHERE employee_id = ? AND department_id = ?"
            );
            stmt.setInt(1, employeeId);
            stmt.setInt(2, currentDepartmentId);
            int result = stmt.executeUpdate();

            // Step 4: Assign the new department to employee
            stmt = conn.prepareStatement(
                "INSERT INTO employee_department (employee_id, department_id) VALUES (?, ?)"
            );
            stmt.setInt(1, employeeId);
            stmt.setInt(2, newDepartmentId);
            result += stmt.executeUpdate();

            return result > 0; // Returns true if update was successful
        } catch (SQLException ex) {
            System.out.println("Error while updating department: " + ex.getMessage());
        }
        return false;
    }


    private int getRoleIdByName(String roleName) {
        try {
            stmt = conn.prepareStatement("SELECT role_id FROM roles WHERE role_name = ?");
            stmt.setString(1, roleName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("role_id");
            }
        } catch (SQLException ex) {
            System.out.println("Error while fetching role ID: " + ex.getMessage());
        }
        return -1; // Return -1 if role name is not found
    }
}
