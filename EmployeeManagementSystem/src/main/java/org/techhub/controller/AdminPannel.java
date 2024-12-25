package org.techhub.controller;
import java.util.*;
import java.util.Scanner;

import org.techhub.model.EmployeeModel;
import org.techhub.service.EmployeeService;
import org.techhub.service.EmployeeServicempl;

public class AdminPannel {
	
	static Scanner scn = new Scanner(System.in);
	static EmployeeService empService = new EmployeeServicempl();
	
	
	public static void AdminCurd() {

		System.out.println("-------> Restaurent Order Management System <---------");

		do {
			System.out.println("<<<-- Enter 0 FOR ADD NEW ADMIN -->>> ");
			System.out.println("<<<-- Enter 1 FOR Employee Manage -->>> ");
			System.out.println("<<<-- Enter 2 FOR Role Manage -->>> ");
			System.out.println("<<<-- Enter 3 FOR department Manage -->>> ");
			
			System.out.println();

			System.out.println("Enter Your Choice :: ");
			int choice = scn.nextInt();
			System.out.println();

			switch (choice) {

			case 0:
				// for adding new admin
				//addAdmin();
				System.out.println();
				break;

			case 1:
				//staffManage();
				System.out.println();
				break;

			case 2:
				//manageRestaurentTables();
				System.out.println();
				break;

			case 3:
				//manageFoodCategery();
				System.out.println();
				break;

			case 4:
				//manageFootItems();
				System.out.println();
				break;

			case 5:
				//showAllCustomers();
				System.out.println();
				break;

			case 6:
				System.out.println("Exiting Admin Pannel... See You Again 🙏🙏");
				//logger.debug("Exiting Admin Pannel... Goodbye!");
				return;

			default:
				System.out.println("Invaid Choice...");
				//logger.error("Invalid Choice! Please try again.");

			}
		} while (true);
		
	
	}
      public static void EmployeManage()
     {
    	  do
    	  {
    		  System.out.println("1.Add new Employee");
    		  System.out.println("2.View All employee");
    		  System.out.println("3.Update Employee by name");
    		  System.out.println("4.delete employee by name");
    		  System.out.println("6.Back to Main Menu");
  			  System.out.println("-------------------------");
  			System.out.println("Enter Your Choice :: ");
			int choice = scn.nextInt();

			switch (choice) {
			case 1:
				addNewEmployee();
				System.out.println();
				break;
				
			}
			
    		  
    	  }while(true);
	
     }
      public static void addNewEmployee()
      {
    	  scn.nextLine();
    	  System.out.println("enter employee Name:");
    	  String name=scn.nextLine();
    	  System.out.println("enter Employee age ");
    	  int age=scn.nextInt();
    	  scn.nextLine();
    	  System.out.println("enter employee gender: ");
    	  String gender=scn.nextLine();
    	  System.out.println("enter employee  salary:");
    	  int salary=scn.nextInt();
    	  EmployeeModel emp=new EmployeeModel();
    	  emp.setEmployeename(name);
    	  emp.setGender(gender);;
    	  emp.setAge(age);
    	  emp.setSalary(salary);
    	  boolean flag=empService.isAddNewEmp(emp);
    	  if (flag) {
  			System.out.println("employee Details Added Successully...");
  		} else {
  			System.out.println("employee Not Added.");
  		}
    	  
    	  
    	  
      }
      private static void showAllEmployees() {
    	    // Fetch all employee details from the service
    	    List<EmployeeModel> employees = empService.showAllEmployees();
    	    
    	    // Display header for clarity
    	    System.out.println("Available Employees in the Organization :: ");
    	    System.out.println("----------------------------------------------------------------");
    	    System.out.println("ID \t | Name \t | Age \t | Gender \t | Salary");
    	    System.out.println("----------------------------------------------------------------");
    	    
    	    // Loop through the list and print each employee's details
    	    for (EmployeeModel emp : employees) {
    	        System.out.println(
    	            emp.getEmployee_id() + " \t | " + 
    	            emp.getEmployeename() + " \t | " + 
    	            emp.getAge() + " \t | " + 
    	            emp.getGender() + " \t | " + 
    	            emp.getSalary()
    	        );
    	    }
    	    System.out.println();
    	}

}


		
	


