package org.techhub.service;

import java.util.List;
import java.util.Map;

import org.techhub.model.RoleModel;

public interface RoleService {
	public boolean addNewRole(RoleModel role);
	 public List<RoleModel> showAllRoles();
	 public List<RoleModel> getRoleByName(String name);
	 public boolean deleteRoleByName(String name);
	 public boolean updateRoleByName(String newName, String newDescription, String oldName);
	 public List<Map<String, Object>> showRolesAndEmployees();

}
