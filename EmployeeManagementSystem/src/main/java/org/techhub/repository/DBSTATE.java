package org.techhub.repository;

import java.sql.*;

import org.techhub.model.EmployeeModel;

public class DBSTATE {
	DBConfing config=DBConfing.getInstance();
	protected Connection conn=config.getConn();
	protected PreparedStatement stmt=config.getStatement();
	protected ResultSet rs=config.getResultSet();
	protected CallableStatement cstmt=config.getCallStatement();
	DBSTATE()
	{
		System.out.println(config.getConn());
	}
	
	
	

}
