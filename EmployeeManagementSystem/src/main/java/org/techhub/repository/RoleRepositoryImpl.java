package org.techhub.repository;

import java.util.ArrayList;
import java.util.List;

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

        }  catch (Exception e) {
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

        }  catch (Exception e) {
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

        }  catch (Exception e) {
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

        }  catch (Exception e) {
            e.printStackTrace();
        }
        return false;
	}

}
