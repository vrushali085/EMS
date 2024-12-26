package org.techhub.service;

import java.util.List;
import org.techhub.model.RoleModel;
import org.techhub.repository.EmployeeRepository;
import org.techhub.repository.EmployeeRepositoryImpl;
import org.techhub.repository.RoleRepository;
import org.techhub.repository.RoleRepositoryImpl;

public class RoleServiceImpl implements RoleService {

	RoleRepository roleRepo = new RoleRepositoryImpl();

    
    
    @Override
    public boolean addNewRole(RoleModel role) {
        
        return roleRepo.addNewRole(role);
    }

    @Override
    public List<RoleModel> showAllRoles() {
        
        return roleRepo.showAllRoles();
    }

    @Override
    public List<RoleModel> getRoleByName(String name) {
        
        return roleRepo.getRoleByName(name);
    }

    @Override
    public boolean deleteRoleByName(String name) {
       
        return roleRepo.deleteRoleByName(name);
    }

    @Override
    public boolean updateRoleByName(String newName, String newDescription, String oldName) {
        
        return roleRepo.updateRoleByName(newName, newDescription, oldName);
    }
}
