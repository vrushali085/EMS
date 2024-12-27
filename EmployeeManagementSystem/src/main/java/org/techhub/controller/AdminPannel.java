package org.techhub.controller;

import java.util.List;

import java.util.Scanner;

import org.techhub.clientApp.MainClass;
import org.techhub.model.AdminModel;
import org.techhub.model.DepartmentModel;
import org.techhub.model.EmployeeModel;
import org.techhub.model.RoleModel;
import org.techhub.service.AdminServiceImpl;
import org.techhub.service.DepartmentService;
import org.techhub.service.DepartmentServiceImpl;
import org.techhub.service.EmployeeAssignmentService;
import org.techhub.service.EmployeeAssignmentServiceImpl;
import org.techhub.service.EmployeeService;
import org.techhub.service.EmployeeServiceImpl;
import org.techhub.service.IAdminService;
import org.techhub.service.RoleService;
import org.techhub.service.RoleServiceImpl;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;


public class AdminPannel {
	static Logger logger = Logger.getLogger(MainClass.class);
	static {
		   SimpleLayout layout=new SimpleLayout();
		   ConsoleAppender appender=new ConsoleAppender(layout);
		   logger.addAppender(appender);
		   logger.setLevel(Level.DEBUG);
	   }
	static Scanner scn = new Scanner(System.in);
	static EmployeeService empService = new EmployeeServiceImpl();
	static RoleService roleService = new RoleServiceImpl();
	static DepartmentService departmentService = new DepartmentServiceImpl();
	private static EmployeeAssignmentService empAssignService = new EmployeeAssignmentServiceImpl();
	private static IAdminService adminService = new AdminServiceImpl();
 
	public static void AdminLogin() {
		
		System.out.println("Enter Username :: ");
		String username = scn.nextLine();
		System.out.println("Enter Password :: ");
		String password = scn.nextLine();
		
		boolean flag = adminService.AdminLogin(username, password);
		
		if(flag ) {
			logger.info("Admin Login Successfully");
			System.out.println("Login Successfully...");
			manageEmployeeDetails();
		}else {
			logger.error("Login Failed check username and password");
			System.out.println("Login Faild Please Check username and password");
		}
		
	}
	
	
	public static void manageEmployeeDetails() {
		System.out.println("------- Employee Management System ---------");
           
		do {
			System.out.println("<<<-- Enter 1 FOR ADD NEW ADMIN -->>> ");
			System.out.println("<<<-- Enter 2 FOR Employee Manage -->>> ");
			System.out.println("<<<-- Enter 3 FOR Role Manage -->>> ");
			System.out.println("<<<-- Enter 4 FOR department Manage -->>> ");
			System.out.println("<<<-- Enter 5 FOR assign Employee to role Manage -->>> ");

			System.out.println();

			System.out.println("Enter Your Choice :: ");
			int choice = scn.nextInt();
			System.out.println();

			switch (choice) {

			case 1:

				 addAdmin();
				System.out.println();
				break;

			case 2:
				employeManage();
				System.out.println();
				break;

			case 3:
				roleManage();
				System.out.println();
				break;

			case 4:
				departmentManage();
				System.out.println();
				break;
			case 5:
				//assignEmployeToRole();
				System.out.println();
				break;
				

			case 6:System.out.println("Exiting Admin Pannel");
			      logger.debug("Exiting Admin Pannel");
				
				return;

			default:
				System.out.println("Invaid Choice...");

			}
		} while (true);

	}
	
	public static void addAdmin() {
		
		scn.nextLine();
		System.out.println("Enter User Name :: ");
		String username = scn.nextLine();
		System.out.println("Enter Password :: ");
		String password = scn.nextLine();

		AdminModel admin = new AdminModel();
		admin.setUsername(username);
		admin.setPassword(password);
		
		boolean flag = adminService.isAddNewAdmin(admin);
		
		if (flag) {
			logger.info("Admin Added Successfully");
			System.out.println("Admin Added Successfully...");
		} else {
			logger.error("Admin Not added ");
			System.out.println("Admin Not Added.");
		}
	}

	public static void employeManage() {
	
		do {
			System.out.println("1.Add new Employee");
			System.out.println("2.View All employee");
			System.out.println("3.Update Employee by name");
			System.out.println("4.delete employee by name");
			System.out.println("5.Back to Main Menu");
			System.out.println("-------------------------");
			System.out.println("Enter Your Choice :: ");
			int choice = scn.nextInt();

			switch (choice) {
			case 1:
				addNewEmployee();
				System.out.println();
				break;

			case 2:
				showAllEmployees();
				System.out.println();
				break;

			case 3:
				updateEmployeeByName();
				System.out.println();
				break;

			case 4:
				deleteEmployeeByName();
				System.out.println();
				break;

			case 6:
				return;

			default:
				System.out.println("Invaid Choice...");

			}

		} while (true);

	}

	public static void addNewEmployee() {
		scn.nextLine();
		System.out.println("enter employee Name:");
		String name = scn.nextLine();
		System.out.println("enter Employee age ");
		int age = scn.nextInt();
		scn.nextLine();
		System.out.println("enter employee gender: ");
		String gender = scn.nextLine();
		System.out.println("enter employee  salary:");
		int salary = scn.nextInt();
		EmployeeModel emp = new EmployeeModel();
		emp.setEmployeename(name);
		emp.setGender(gender);
		;
		emp.setAge(age);
		emp.setSalary(salary);
		boolean flag = empService.isAddNewEmp(emp);
		if (flag) {
			logger.info("employee details added Successfully");
			System.out.println("employee Details Added Successully...");
		} else {
			logger.error("Employee details not added ");
			System.out.println("employee Not Added.");
		}

	}

	public static void showAllEmployees() {
		// Fetch all employees from the service layer
		List<EmployeeModel> employees = empService.showAllEmployee();

		if (employees == null || employees.isEmpty()) {
			System.out.println("No employees found in the organization.");
			return;
		}

		// Display header for clarity
		System.out.println("Available Employees in the Organization :: ");
		System.out.println("----------------------------------------------------------------");
		System.out.println("ID \t | Name \t | Age \t | Gender \t | Salary");
		System.out.println("----------------------------------------------------------------");

		// Loop through the list and print each employee's details
		for (EmployeeModel employee : employees) {
			System.out.println(employee.getEmployee_id() + " \t | " + employee.getEmployeename() + " \t | "
					+ employee.getAge() + " \t | " + employee.getGender() + " \t | " + employee.getSalary());
		}
		System.out.println();
	}

	public static void updateEmployeeByName() {
		scn.nextLine(); // Clear the scanner buffer
		System.out.println("Enter the name of the employee you want to update:");
		String oldName = scn.nextLine();

		System.out.println("Enter the new name for the employee:");
		String newName = scn.nextLine();

		System.out.println("Enter the new age for the employee:");
		int newAge = scn.nextInt();
		scn.nextLine(); // Clear the scanner buffer

		System.out.println("Enter the new gender for the employee:");
		String newGender = scn.nextLine();

		System.out.println("Enter the new salary for the employee:");
		int newSalary = scn.nextInt();

		// Call the update method in the service layer
		boolean flag = empService.updateEmployeeByName(newName, newAge, newGender, newSalary, oldName);
		if (flag) {
			logger.info("Employee details updated Successfully");
			System.out.println("Employee details updated successfully.");
		} else {
			logger.error("Failed to update employee details");
			System.out.println("Failed to update employee details. Please check the provided name.");
		}
	}

	public static void deleteEmployeeByName() {
		scn.nextLine(); // Clear the scanner buffer
		System.out.println("Enter the name of the employee you want to delete:");
		String name = scn.nextLine();

		// Call the delete method in the service layer
		boolean flag = empService.deleteEmployeeByName(name);
		if (flag) {
			logger.info("Employee deleted  Successfully");
			System.out.println("Employee deleted successfully.");
		} else {
			logger.error("Failed to delete employee");
			System.out.println("Failed to delete employee. Please check the provided name.");
		}
	}

	public static void roleManage() {
		do {
			System.out.println("1. Add New Role");
			System.out.println("2. View All Roles");
			System.out.println("3. Update Role by Name");
			System.out.println("4. Delete Role by Name");
			System.out.println("5. Back to Main Menu");
			System.out.println("-------------------------");
			System.out.println("Enter Your Choice :: ");
			int choice = scn.nextInt();

			switch (choice) {
			case 1:
				addNewRole();
				System.out.println();
				break;

			case 2:
				showAllRoles();
				System.out.println();
				break;

			case 3:
				updateRoleByName();
				System.out.println();
				break;

			case 4:
				deleteRoleByName();
				System.out.println();
				break;

			case 5:
				return;

			default:
				System.out.println("Invalid Choice...");
			}

		} while (true);
	}

	public static void addNewRole() {
		scn.nextLine(); // Clear the scanner buffer
		System.out.println("Enter Role Name:");
		String name = scn.nextLine();
		System.out.println("Enter Role Description:");
		String description = scn.nextLine();

		// Create a RoleModel object and set its properties
		RoleModel role = new RoleModel();
		role.setRolename(name);
		role.setRole_description(description);

		// Call the add method in the service layer
		boolean flag = roleService.addNewRole(role);
		if (flag) {
			logger.info("Role Added Successfully");
			System.out.println("Role added successfully.");
		} else {
			logger.error("Failed to add role");
			System.out.println("Failed to add role.");
		}
	}

	public static void showAllRoles() {
		// Fetch all roles from the service layer
		List<RoleModel> roles = roleService.showAllRoles();

		// Display header for clarity
		System.out.println("Available Roles in the Organization :: ");
		System.out.println("----------------------------------------------------------------");
		System.out.println("ID \t | Name \t | Description");
		System.out.println("----------------------------------------------------------------");

		// Loop through the list and print each role's details
		for (RoleModel role : roles) {
			System.out
					.println(role.getRole_id() + " \t | " + role.getRolename() + " \t | " + role.getRole_description());
		}
		System.out.println();
	}

	public static void updateRoleByName() {
		scn.nextLine(); // Clear the scanner buffer
		System.out.println("Enter the name of the role you want to update:");
		String oldName = scn.nextLine();

		System.out.println("Enter the new name for the role:");
		String newName = scn.nextLine();

		System.out.println("Enter the new description for the role:");
		String newDescription = scn.nextLine();

		// Call the update method in the service layer
		boolean flag = roleService.updateRoleByName(newName, newDescription, oldName);
		if (flag) {
			logger.info("role details updated Successfully");
			System.out.println("Role details updated successfully.");
		} else {
			logger.error("Failed to update role details");
			System.out.println("Failed to update role details. Please check the provided name.");
		}
	}

	public static void deleteRoleByName() {
		scn.nextLine(); // Clear the scanner buffer
		System.out.println("Enter the name of the role you want to delete:");
		String name = scn.nextLine();

		// Call the delete method in the service layer
		boolean flag = roleService.deleteRoleByName(name);
		if (flag) {
			logger.info("Role deleted Successfully");
			System.out.println("Role deleted successfully.");
		} else {
			logger.error("failed to delete role");
			System.out.println("Failed to delete role. Please check the provided name.");
		}
	}

	public static void departmentManage() {
		do {
			System.out.println("1. Add New Department");
			System.out.println("2. View All Departments");
			System.out.println("3. Update Department by Name");
			System.out.println("4. Delete Department by Name");
			System.out.println("5. Back to Main Menu");
			System.out.println("-------------------------");
			System.out.print("Enter Your Choice :: ");
			int choice = scn.nextInt();

			switch (choice) {
			case 1:
				addNewDepartment();
				break;

			case 2:
				showAllDepartments();
				break;

			case 3:
				updateDepartmentByName();
				break;

			case 4:
				deleteDepartmentByName();
				break;

			case 5:
				return; // Go back to the main menu

			default:
				System.out.println("Invalid Choice...");
			}

		} while (true);
	}

	public static void addNewDepartment() {
		scn.nextLine(); // Clear the scanner buffer
		System.out.println("Enter Department Name:");
		String name = scn.nextLine();
		System.out.println("Enter Department Location:");
		String location = scn.nextLine();

		// Create a DepartmentModel object and set its properties
		DepartmentModel department = new DepartmentModel();
		department.setName(name);
		department.setLocation(location);

		// Call the add method in the service layer
		boolean flag = departmentService.addNewDepartment(department);
		if (flag) {
			logger.info("Department added Successfully");
			System.out.println("Department added successfully.");
		} else {
			logger.error("Failed to add department");
			System.out.println("Failed to add department.");
		}
	}

	public static void showAllDepartments() {
		// Fetch all departments from the service layer
		List<DepartmentModel> departments = departmentService.showAllDepartments();

		// Display header for clarity
		System.out.println("Available Departments in the Organization :: ");
		System.out.println("----------------------------------------------------------------");
		System.out.println("ID \t | Name \t | Location");
		System.out.println("----------------------------------------------------------------");

		// Loop through the list and print each department's details
		for (DepartmentModel department : departments) {
			System.out.println(department.getDepartment_id() + " \t | " + department.getName() + " \t | "
					+ department.getLocation());
		}
		System.out.println();
	}

	public static void updateDepartmentByName() {
		scn.nextLine(); // Clear the scanner buffer
		System.out.println("Enter the name of the department you want to update:");
		String oldName = scn.nextLine();

		System.out.println("Enter the new name for the department:");
		String newName = scn.nextLine();

		System.out.println("Enter the new location for the department:");
		String newLocation = scn.nextLine();

		// Call the update method in the service layer
		boolean flag = departmentService.updateDepartmentByName(newName, newLocation, oldName);
		if (flag) {
			logger.info("Department Details Added Successfully");
			System.out.println("Department details updated successfully.");
		} else {
			logger.error("Failed to update");
			System.out.println("Failed to update department details. Please check the provided name.");
		}
	}

	public static void deleteDepartmentByName() {
		scn.nextLine(); // Clear the scanner buffer
		System.out.println("Enter the name of the department you want to delete:");
		String name = scn.nextLine();

		// Call the delete method in the service layer
		boolean flag = departmentService.deleteDepartmentByName(name);
		if (flag) {
			logger.info("Department deleted Successfully");
			System.out.println("Department deleted successfully.");
		} else {
			logger.error("Failed to delete department");
			System.out.println("Failed to delete department. Please check the provided name.");
		}
	}
	
	public static void manageEmployeeAssignments() {
	    System.out.println("1. Assign Role to Employee");
	    System.out.println("2. Assign Department to Employee");
	    System.out.println("3. View Assignments for Employee");
	    System.out.println("4. Update Role Assignment");
	    System.out.println("5. Update Department Assignment");
	    System.out.println("6. Remove Role from Employee");
	    System.out.println("7. Remove Department from Employee");
	    System.out.println("8. Back to Main Menu");
	    System.out.print("Enter Your Choice: ");
	    int choice = scn.nextInt();

	    switch (choice) {
	        case 1:
	            // Logic for assigning role
	            break;
	        case 2:
	            // Logic for assigning department
	            break;
	        case 3:
	            // Logic for viewing assignments
	            break;
	        case 4:
	            // Logic for updating role
	            break;
	        case 5:
	            // Logic for updating department
	            break;
	        case 6:
	            // Logic for removing role
	            break;
	        case 7:
	            // Logic for removing department
	            break;
	        case 8:
	            return;
	        default:
	            System.out.println("Invalid Choice");
	    }
	}

}
