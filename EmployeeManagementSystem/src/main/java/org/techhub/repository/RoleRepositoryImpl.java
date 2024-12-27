package org.techhub.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.techhub.model.RoleModel;

public class RoleRepositoryImpl extends DBSTATE implements RoleRepository {

    @Override
    public boolean addNewRole(RoleModel role) {
        try {
            stmt = conn.prepareStatement("INSERT INTO role (rolename, role_description) VALUES (?, ?)");
            stmt.setString(1, role.getRolename());
            stmt.setString(2, role.getRole_description());

            int value = stmt.executeUpdate();
            return value > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<RoleModel> showAllRoles() {
        List<RoleModel> roleList = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT * FROM role");
            rs = stmt.executeQuery();

            while (rs.next()) {
                RoleModel role = new RoleModel();
                role.setRole_id(rs.getInt("role_id"));
                role.setRolename(rs.getString("rolename"));
                role.setRole_description(rs.getString("role_description"));

                roleList.add(role);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public List<RoleModel> getRoleByName(String name) {
        List<RoleModel> roleList = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT * FROM role WHERE rolename LIKE ?");
            stmt.setString(1, "%" + name + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                RoleModel role = new RoleModel();
                role.setRole_id(rs.getInt("role_id"));
                role.setRolename(rs.getString("rolename"));
                role.setRole_description(rs.getString("role_description"));

                roleList.add(role);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public boolean deleteRoleByName(String name) {
        try {
            stmt = conn.prepareStatement("DELETE FROM role WHERE rolename = ?");
            stmt.setString(1, name);
            int value = stmt.executeUpdate();
            return value > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateRoleByName(String newName, String newDescription, String oldName) {
        try {
            stmt = conn.prepareStatement("UPDATE role SET rolename = ?, role_description = ? WHERE rolename = ?");
            stmt.setString(1, newName);
            stmt.setString(2, newDescription);
            stmt.setString(3, oldName);

            int value = stmt.executeUpdate();
            return value > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Map<String, Object>> showRolesAndEmployees() {
        List<Map<String, Object>> employeeRoles = new ArrayList<>();
        String query = "SELECT e.employee_id, e.employeename, r.rolename " +
                       "FROM employee e " +
                       "INNER JOIN employee_role er ON e.employee_id = er.employee_id " +
                       "INNER JOIN role r ON er.role_id = r.role_id";

        try (PreparedStatement stmt = conn.prepareStatement(query); 
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Map<String, Object> data = new HashMap<>();
                data.put("employee_id", rs.getInt("employee_id"));
                data.put("employeename", rs.getString("employeename"));
                data.put("rolename", rs.getString("rolename"));
                employeeRoles.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeRoles;
    }
}



