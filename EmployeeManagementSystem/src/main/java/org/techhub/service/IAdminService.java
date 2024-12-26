package org.techhub.service;

import org.techhub.model.AdminModel;

public interface IAdminService {
	
	public boolean isAddNewAdmin(AdminModel admin);
	
	public boolean AdminLogin(String username, String password);
}
