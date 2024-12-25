package org.techhub.repository;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
public class DBConfing {
	protected static  Connection conn;
	protected static  PreparedStatement stmt;
	protected static ResultSet rs;
	protected static CallableStatement cstmt;
	private static DBConfing db;
	private DBConfing()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			File f=new File("");
			String path=f.getAbsolutePath();
			System.out.println(path);
			FileInputStream inputStream=new FileInputStream(path+"\\src\\main\\resources\\DBConfig.properties");
			Properties p=new Properties();
			p.load(inputStream);
			String driverClassName=p.getProperty("driver");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			String url=p.getProperty("url");
			System.out.println(driverClassName);
			System.out.println(username);
			System.out.println(password);
			System.out.println(url);
		 conn=DriverManager.getConnection(url,username,password);
			
			
			
		}
		catch(Exception ex) {
			System.out.println("error is "+ex);
		}
		
	}
	public static DBConfing getInstance()
	{
		if(db==null)
		{
			db=new DBConfing();
			
		}
		return db;
	}
	public static Connection getConn() {
		return conn;
	}
	public static PreparedStatement getStatement()
	{
		return stmt;
		
	}
	public static ResultSet getResultSet()
	{
		return rs;
		
	}
	public static CallableStatement getCallStatement()
	{
		return cstmt;
		
	}
	

}
