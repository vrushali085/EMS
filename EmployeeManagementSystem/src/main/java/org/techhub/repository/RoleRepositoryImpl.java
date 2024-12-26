package org.techhub.repository;

import java.util.List;

import org.techhub.model.RoleModel;

public class RoleRepositoryImpl implements RoleRepository {

	@Override
	public boolean addNewRole(RoleModel role) {
		return false;
//		try {
//            stmt = conn.prepareStatement("INSERT INTO role (rolename, role_description) VALUES (?, ?)");
//            stmt.setString(1, role.getRolename());
//            stmt.setString(2, role.getRole_description());
//
//            int value = stmt.executeUpdate();
//            return value > 0;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//           
//        } catch (Exception e) {
//            e.printStackTrace();
//            
//        }
//        return false;
//    }
	}

	@Override
	public List<RoleModel> showAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleModel> getRoleByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteRoleByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRoleByName(String newName, String newDescription, String oldName) {
		// TODO Auto-generated method stub
		return false;
	}

}
