package org.techhub.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAssignmentRepositoryImpl extends DBSTATE implements EmployeeAssignmentRepository {

	// Get Roles for an Employee using employeeName
	@Override
	public List<String> getRolesForEmployee(String employeeName) {
		List<String> roles = new ArrayList<>();
		String sql = "SELECT r.rolename FROM employee e " + "JOIN employee_role er ON e.employee_id = er.employee_id "
				+ "JOIN role r ON er.role_id = r.role_id " + "WHERE e.employeename = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, employeeName);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					roles.add(rs.getString("rolename"));
				}
			}
		} catch (SQLException ex) {
			System.out.println("Error while fetching roles: " + ex);
		}
		return roles;
	}

	// Remove Role from Employee using Employee Name and Role Name
	@Override
	public boolean removeRoleFromEmployee(String employeeName, String roleName) {
		String sql = "DELETE er FROM employee_role er " + "JOIN employee e ON er.employee_id = e.employee_id "
				+ "JOIN role r ON er.role_id = r.role_id " + "WHERE e.employeename = ? AND r.rolename = ?";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, employeeName); // Set employee name
			stmt.setString(2, roleName); // Set role name

			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0; // Return true if at least one row was deleted
		} catch (SQLException ex) {
			System.err.println("Error while removing role: " + ex.getMessage());
		}
		return false; // Return false if an exception occurs or no rows are deleted
	}

	// Get Departments for Employee using employeeId
	@Override
	public List<String> getDepartmentsForEmployee(int employeeId) {
	    List<String> departments = new ArrayList<>();
	    String sql = "SELECT d.name FROM employee_department ed " +
	                 "JOIN department d ON ed.department_id = d.department_id " +
	                 "WHERE ed.employee_id = ?";
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, employeeId); // Set employeeId

	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                departments.add(rs.getString("name")); // Fetch department name
	            }
	        }
	    } catch (SQLException ex) {
	        System.out.println("Error while fetching departments: " + ex);
	    }
	    return departments;
	}


	// Assign Department to Employee using employeeName and departmentId
	@Override
	public boolean assignDepartmentToEmployeeByName(String employeeName, int departmentId) {
	    // Query to get the employee_id based on the employeeName
	    String sql = "INSERT INTO employee_department (employee_id, department_id) " +
	                 "SELECT e.employee_id, ? FROM employee e WHERE e.employeename = ?";

	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, departmentId); // Set departmentId
	        stmt.setString(2, employeeName); // Set employeeName

	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0; // Return true if at least one row was inserted
	    } catch (SQLException ex) {
	        System.err.println("Error while assigning department: " + ex.getMessage());
	    }
	    return false; // Return false if an exception occurs or no rows are inserted
	}


	// Assign Role to Employee using employeeId and role_id
	@Override
	public boolean assignRoleToEmployee(int employeeId, int role_id) {
		String sql = "INSERT INTO employee_role (employee_id, role_id) VALUES (?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, employeeId);
			stmt.setInt(2, role_id);

			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0; // Return true if at least one row was inserted
		} catch (SQLException ex) {
			System.err.println("Error while assigning role: " + ex.getMessage());
		}
		return false;
	}
	// Remove Department from Employee using Employee Name and Department Name
	@Override
	public boolean removeDepartmentFromEmployee(String employeeName, String departmentName) {
	    String sql = "DELETE ed FROM employee_department ed " +
	                 "JOIN employee e ON ed.employee_id = e.employee_id " +
	                 "JOIN department d ON ed.department_id = d.department_id " +
	                 "WHERE e.employeename = ? AND d.name = ?";

	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, employeeName); // Set employee name
	        stmt.setString(2, departmentName); // Set department name

	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0; // Return true if at least one row was deleted
	    } catch (SQLException ex) {
	        System.err.println("Error while removing department: " + ex.getMessage());
	    }
	    return false; // Return false if an exception occurs or no rows are deleted
	}

}
