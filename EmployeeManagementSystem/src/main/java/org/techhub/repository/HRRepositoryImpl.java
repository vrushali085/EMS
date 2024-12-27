package org.techhub.repository;

public class HRRepositoryImpl extends DBSTATE implements IHRRepository {

	@Override
	public boolean HRLogin(String roleName, int empId) {
		try {
			
			stmt = conn.prepareStatement("SELECT e.employeename, r.rolename FROM employee e INNER JOIN employee_role er ON er.employee_id = e.employee_id INNER JOIN role r ON r.role_id = er.role_id WHERE r.rolename = ? AND e.employee_id = ?");
			stmt.setInt(2, empId);
			stmt.setString(1, roleName);
			
			rs = stmt.executeQuery();
			
			return rs.next();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
