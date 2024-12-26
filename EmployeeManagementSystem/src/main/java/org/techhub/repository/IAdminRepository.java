package org.techhub.repository;

import org.techhub.model.AdminModel;

public interface IAdminRepository {
	
	public boolean isAddNewAdmin(AdminModel admin);
	
	public boolean adminLogin(String uername, String password);
}
