package org.techhub.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.techhub.model.AttendanceModel;
import org.techhub.model.AttendanceStatus; // Import the enum
import org.techhub.repository.DBSTATE;
import org.techhub.service.AttendanceService;
import org.techhub.service.AttendanceServiceImpl;
import org.techhub.service.HRService;
import org.techhub.service.HRServiceImpl;

public class HRPanel  {
	static Scanner scn = new Scanner(System.in);
	static AttendanceService attendanceService = new AttendanceServiceImpl();
	static HRService hrService = new HRServiceImpl();

	public static void HRLogin() {

		AdminPannel.displayRolesAndEmployees();

		System.out.println("Enter Employee Id :: ");
		int empId = scn.nextInt();
		scn.nextLine(); // Clear buffer

		System.out.println("Enter HR Role :: ");
		String hrRole = scn.nextLine();
		boolean isHR = hrService.HRLogin(hrRole, empId);

		if (isHR) {
			System.out.println("HR Login Successful!");
			System.out.println();
			manageAttendance();
		} else {
			System.out.println("Access Denied: You are not authorized as HR.");
			System.out.println();
		}
	}

	public static void manageAttendance() {
		do {
			System.out.println("<<<-- Attendance Management -->>>");
			
			
			System.out.println("1. Mark Attendance");
			System.out.println("2. View Attendance");
			System.out.println("3.view Employees");
			System.out.println("4.View DepartmentsCalculateSalary()");
			System.out.println("5.Assign role to employee");
			System.out.println("6.7Asign department to employee");
			System.out.println("3. Logout");

			System.out.print("Enter your choice: ");
			int choice = scn.nextInt();
			scn.nextLine(); 

			switch (choice) {
			case 1:
				markAttendance();
				break;
			case 2:
				viewAttendance();
				break;
			case 3:
				AdminPannel.showAllEmployees();
				break;
			case 4:
				CalculateSalary();
				break;
			case 7 :
				System.out.println("Logging out...");
				return;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		} while (true);
	}

	
	
	public static void markAttendance() {
	    // Step 1: Get Employee ID
	    System.out.println("Enter Employee ID: ");
	    int employeeId = scn.nextInt();
	    scn.nextLine(); // Clear the buffer

	    // Step 2: Get and Parse Date
	    System.out.println("Enter Date (YYYY-MM-DD): ");
	    String dateString = scn.nextLine();
	    LocalDate date;
	    try {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        date = LocalDate.parse(dateString, formatter);
	    } catch (Exception e) {
	        System.out.println("Invalid date format. Please use YYYY-MM-DD.");
	        return; // Exit the method
	    }

	    // Step 3: Prompt for Attendance Status
	    System.out.println("Enter Status (PRESENT, ABSENT, LEAVE, LATE, WORK_FROM_HOME, HOLIDAY, HALF_DAY): ");
	    String statusString = scn.nextLine().trim().toUpperCase(); // Convert input to uppercase

	    // Step 4: Validate Attendance Status
	    AttendanceStatus status;
	    try {
	        status = AttendanceStatus.valueOf(statusString); // Match input with enum
	    } catch (IllegalArgumentException e) {
	        System.out.println("Invalid Status. Please choose from the following options:");
	        for (AttendanceStatus validStatus : AttendanceStatus.values()) {
	            System.out.println(validStatus.name()); // Display valid statuses
	        }
	        return; // Exit the method
	    }

	    // Step 5: Fetch HR Employees
	   
	    // Step 6: Prompt for HR Employee ID
	    System.out.println("Select HR Employee ID for verification:");

	    int verifiedBy = scn.nextInt();
	   

	    // Step 7: Create AttendanceModel Object
	    int attendanceId = 0; // Auto-generated ID
	    boolean isVerified = true; // Verified since HR is involved
	    boolean isMarked = true; // Mark attendance upon creation

	    AttendanceModel attendance = new AttendanceModel(attendanceId, employeeId, date, status.toString(), isVerified,
	            verifiedBy, isMarked);

	    // Step 8: Save Attendance
	    boolean isMarkedSuccessfully = attendanceService.markAttendance(attendance);
	    if (isMarkedSuccessfully) {
	        System.out.println("Attendance marked successfully for Employee ID: " + employeeId);
	    } else {
	        System.out.println("Failed to mark attendance.");
	    }
	}

	
	
	
	
	
	
	
//	public static void markAttendance() {
//		// Step 1: Get Employee ID
//		System.out.println("Enter Employee ID: ");
//		int employeeId = scn.nextInt();
//		scn.nextLine(); // Clear the buffer
//
//		// Step 2: Get and Parse Date
//		System.out.println("Enter Date (YYYY-MM-DD): ");
//		String dateString = scn.nextLine();
//		LocalDate date;
//		try {
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			date = LocalDate.parse(dateString, formatter);
//		} catch (Exception e) {
//			System.out.println("Invalid date format. Please use YYYY-MM-DD.");
//			return; // Exit the method
//		}
//
//		// Step 3: Prompt for Attendance Status
//		System.out.println("Enter Status (PRESENT, ABSENT, LEAVE, LATE, WORK_FROM_HOME, HOLIDAY, HALF_DAY): ");
//		String statusString = scn.nextLine().trim().toUpperCase(); // Convert input to uppercase
//
//		// Step 4: Validate Attendance Status
//		AttendanceStatus status;
//		try {
//			status = AttendanceStatus.valueOf(statusString); // Match input with enum
//		} catch (IllegalArgumentException e) {
//			System.out.println("Invalid Status. Please choose from the following options:");
//			for (AttendanceStatus validStatus : AttendanceStatus.values()) {
//				System.out.println(validStatus.name()); // Display valid statuses
//			}
//			return; // Exit the method
//		}
//
//		// Step 5: Create AttendanceModel Object
//		int attendanceId = 0; // Auto-generated ID
//		boolean isVerified = true; // Not verified initially
//		
//		
//		
//		System.out.println("Enter Employee Id :: ");
//		int verifiedBy = scn.nextInt();
//		
//		boolean isMarked = true; // Mark attendance upon creation
//
//		AttendanceModel attendance = new AttendanceModel(attendanceId, employeeId, date, status.toString(), isVerified,
//				verifiedBy, isMarked);
//
//		// Step 6: Save Attendance
//		boolean isMarkedSuccessfully = attendanceService.markAttendance(attendance);
//		if (isMarkedSuccessfully) {
//			System.out.println("Attendance marked successfully for Employee ID: " + employeeId);
//		} else {
//			System.out.println("Failed to mark attendance.");
//		}
//	}
//


	private static List<Integer> fetchHREmployeeIds() {
	    List<Integer> hrEmployeeIds = new ArrayList<>();
	    String query = "SELECT e.employee_id FROM employee e " +
	                   "INNER JOIN employee_role er ON er.employee_id = e.employee_id " +
	                   "INNER JOIN role r ON r.role_id = er.role_id " +
	                   "WHERE r.rolename = 'HR'";

	    try {
	    	
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "vrushali");
	        PreparedStatement stmt = conn.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            hrEmployeeIds.add(rs.getInt("employee_id"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return hrEmployeeIds;
	}

	
	

	public static void viewAttendance() {
		System.out.println("Enter Employee ID to view attendance: ");
		int employeeId = scn.nextInt();

		List<AttendanceModel> attendanceRecords = attendanceService.getAttendanceByEmployeeId(employeeId);
		if (attendanceRecords.isEmpty()) {
			System.out.println("No attendance records found.");
		} else {
			for (AttendanceModel record : attendanceRecords) {
				System.out.println(record); // Print attendance records
			}
		}
	}
	
	public static void CalculateSalary()
	{
		 AttendanceServiceImpl attendanceService = new AttendanceServiceImpl();

	        System.out.println("enter employee id to calculate salary");
	        int employeeId = scn.nextInt();

	        // Define the date range for which the salary needs to be calculated
	        LocalDate startDate = LocalDate.of(2024, 12, 1);  // Start date: 1st December 2024
	        LocalDate endDate = LocalDate.of(2024, 12, 31);   // End date: 31st December 2024

	        // Calculate the salary for the given employee and date range
	        double totalSalary = attendanceService.calculateSalary(employeeId, startDate, endDate);

	        // Print the calculated salary
	        System.out.println("Total salary for employee with ID " + employeeId + " from " + startDate + " to " + endDate + " is: " + totalSalary);
	}
}



