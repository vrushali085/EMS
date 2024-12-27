package org.techhub.repository;

import java.io.File;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
public class DBConfing {
	protected static  Connection conn;
	protected static  PreparedStatement stmt;
	protected static ResultSet rs;
	protected static CallableStatement cstmt;
	private static DBConfing db;
	private static Logger logger= Logger.getLogger(DBConfing.class);
	
	 static {
		   SimpleLayout layout=new SimpleLayout();
		   ConsoleAppender appender=new ConsoleAppender(layout);
		   logger.addAppender(appender);
		   logger.setLevel(Level.DEBUG);
	   }
	private DBConfing(){
		try {
			logger=Logger.getLogger(DBConfing.class);
			System.out.println("Attempting to establish a database connection...");
		    logger.info("Loading driver class...");
		    Class.forName("com.mysql.cj.jdbc.Driver");

		    System.out.println("Driver loaded successfully.");
		    logger.info("Driver loaded successfully.");

			Class.forName("com.mysql.cj.jdbc.Driver");
			File f=new File("");
			String path=f.getAbsolutePath();
			System.out.println(path);
			FileInputStream inputStream=new FileInputStream(path+"\\src\\main\\resources\\dbConfig.properties");
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
		 if(conn!=null) {
			 logger.info("Database is Connected");
			 System.out.println("Database is Connected");
			 
		 }
		 else {
			 logger.error("Database Connection Failed");
			 System.out.println("Database connection failed");
		 }
			
			
			
		}
		
			catch (Exception ex) {
			    logger.error("Error occurred while connecting to the database: ", ex);
			    System.out.println("Error occurred: " + ex.getMessage());
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
