package org.techhub.service;

import org.techhub.model.AdminModel;
import org.techhub.repository.AdminRepositoryImpl;
import org.techhub.repository.IAdminRepository;

public class AdminServiceImpl implements IAdminService {

	IAdminRepository adminRepo = new AdminRepositoryImpl();
	
	@Override
	public boolean isAddNewAdmin(AdminModel admin) {
		
		return adminRepo.isAddNewAdmin(admin);
	}

	@Override
	public boolean AdminLogin(String username, String password) {
		
		
		return adminRepo.adminLogin(username, password);
	}

}
