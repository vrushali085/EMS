package org.techhub.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.techhub.model.EmployeeModel;

public class EmployeeRepositoryImpl extends DBSTATE implements EmployeeRepository{

	public boolean isAddNewEmp(EmployeeModel model) {
		try {
			stmt = conn.prepareStatement("insert into employee values('0',?,?,?,?)");
			stmt.setString(1, model.getEmployeename());
			stmt.setInt(2, model.getAge());
			stmt.setString(3, model.getGender());
			stmt.setInt(4, model.getSalary());
			
			int value = stmt.executeUpdate();
			if (value > 0)
				return true;
			else
				return false;

		} catch (Exception ex) {
			System.out.println("error is"+ex);

		}

		
		return false;
	}
/*
	@Override
	public List<EmployeeModel> showAllEmployee() {
		List<EmployeeModel> employeeList = new ArrayList<>();
		try
		{
		stmt=conn.prepareStatement("select * from employee");
		rs=stmt.executeQuery();
		while(rs.next())
		{
			EmployeeModel employee = new EmployeeModel();
            employee.setEmployee_id(rs.getInt("employee_id"));
            employee.setEmployeename(rs.getString("employeename"));
            employee.setAge(rs.getInt("age"));
            employee.setGender(rs.getString("gender"));
            employee.setSalary(rs.getInt("salary"));
            employeeList.add(employee);
            
            return employeeList;
		}
		}
		catch(Exception ex)
		{
			System.out.println("error is "+ex);
		}
		
		return null;
	}
*/
	@Override
	public List<EmployeeModel> showAllEmployee() {
	    List<EmployeeModel> employeeList = new ArrayList<>();
	    try {
	        stmt = conn.prepareStatement("SELECT * FROM employee");
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            EmployeeModel employee = new EmployeeModel();
	            employee.setEmployee_id(rs.getInt("employee_id"));
	            employee.setEmployeename(rs.getString("employeename"));
	            employee.setAge(rs.getInt("age"));
	            employee.setGender(rs.getString("gender"));
	            employee.setSalary(rs.getInt("salary"));
	            employeeList.add(employee);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return employeeList;
	}

	@Override
	public List<EmployeeModel> getEmployeesByName(String name) {
		 {
		    List<EmployeeModel> employeeList = new ArrayList<>();
		    try {
		        stmt = conn.prepareStatement("SELECT * FROM employee WHERE employeename LIKE ?");
		        stmt.setString(1, "%" + name + "%");
		        rs = stmt.executeQuery();

		        while (rs.next()) {
		            EmployeeModel employee = new EmployeeModel();
		            employee.setEmployee_id(rs.getInt("employee_id"));
		            employee.setEmployeename(rs.getString("employeename"));
		            employee.setAge(rs.getInt("age"));
		            employee.setGender(rs.getString("gender"));
		            employee.setSalary(rs.getInt("salary"));
		            employeeList.add(employee);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		        
		    }
		    return employeeList;
		}

		
	}

	@Override
	public boolean deleteEmployeeByName(String name) {
		try {
	        stmt = conn.prepareStatement("DELETE FROM employee WHERE employeename = ?");
	        stmt.setString(1, name);
	        int value = stmt.executeUpdate();
	        return value > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    } catch (Exception ex) {
	        System.out.println("error is "+ex);
	        
	    }
	    return false;
	}

	@Override
	public EmployeeModel getEmployeeById(int employeeId) {
	    String query = "SELECT * FROM employee WHERE employee_id = ?";
	    EmployeeModel employee = null;

	    try {
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, employeeId);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            int empId = rs.getInt("employee_id");
	            String name = rs.getString("employeename");
	            int age = rs.getInt("age");
	            String gender = rs.getString("gender");
	            int salary = rs.getInt("salary");

	            // Correctly construct an EmployeeModel object
	            employee = new EmployeeModel(empId, name, age, gender, salary);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return employee; // Return null if no employee is found
	}

		@Override
		public boolean updateEmployeeByName(String newName, int age, String gender, int salary, String oldName) {
		    try {
		        stmt = conn.prepareStatement("UPDATE employee SET employeename = ?, age = ?, gender = ?, salary = ? WHERE employeename = ?");
		        stmt.setString(1, newName);
		        stmt.setInt(2, age);
		        stmt.setString(3, gender);
		        stmt.setInt(4, salary);
		        stmt.setString(5, oldName);

		        int value = stmt.executeUpdate();
		        return value > 0;

		    } catch (SQLException e) {
		        e.printStackTrace();
		        
		    } catch (Exception ex) {
		    	
			        System.out.println("error is "+ex);
			        
			    }
		        
		    

		    return false;
		}

	}
	
	


