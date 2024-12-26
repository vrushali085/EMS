package org.techhub.repository;

import org.techhub.model.AdminModel;

public class AdminRepositoryImpl extends DBSTATE implements IAdminRepository {

	@Override
	public boolean isAddNewAdmin(AdminModel admin) {

		try {

			stmt = conn.prepareStatement("insert into admin values('0',?,?)");
			stmt.setString(1, admin.getUsername());
			stmt.setString(2, admin.getPassword());

			int value = stmt.executeUpdate();

			return value > 0 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean adminLogin(String uername, String password) {
		try {
			
			stmt = conn.prepareStatement("select * from admin where username=? && password=?");
			stmt.setString(1, uername);
			stmt.setString(2, password);
			
			rs = stmt.executeQuery();
			
			return rs.next();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
