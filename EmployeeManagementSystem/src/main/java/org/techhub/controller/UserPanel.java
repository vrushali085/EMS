package org.techhub.controller;

import org.techhub.model.EmployeeModel;
import org.techhub.model.AttendanceModel;
import org.techhub.service.EmployeeService;
import org.techhub.service.EmployeeServiceImpl;
import org.techhub.service.RoleService;
import org.techhub.service.RoleServiceImpl;
import org.techhub.service.AttendanceService;
import org.techhub.service.AttendanceServiceImpl;
import java.util.List;
import java.util.Scanner;

public class UserPanel {
    static Scanner scn = new Scanner(System.in);
    static EmployeeService empService = new EmployeeServiceImpl();
	static RoleService roleService = new RoleServiceImpl();
	static AttendanceService attendanceService = new AttendanceServiceImpl();
    
/*public static void AdminLogin() {
		
		System.out.println("Enter Username :: ");
		String username = scn.nextLine();
		System.out.println("Enter Password :: ");
		String password = scn.nextLine();
		
		boolean flag = userService.UserLogin(username, password);
		
		if(flag ) {
			System.out.println("Login Successfully...");
			manageEmployeeDetails();
		}else {
			System.out.println("Login Faild Please Check username and password");
		}
		
	}*/
    public static void UserDashboard() {
        System.out.println("------- User Dashboard ---------");

        do {
            System.out.println("<<<-- Enter 1 FOR View Personal Details -->>> ");
            System.out.println("<<<-- Enter 2 FOR Mark Attendance -->>> ");
            System.out.println("<<<-- Enter 3 FOR View Attendance History -->>> ");
            System.out.println("<<<-- Enter 4 FOR Request Leave -->>> ");
            System.out.println("<<<-- Enter 5 FOR View Reports -->>> ");
            System.out.println("<<<-- Enter 6 FOR Log Out -->>> ");																																																																																																																																																															
            System.out.print("Enter Your Choice :: ");
            
            int choice = scn.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    viewPersonalDetails();
                    break;
                case 2:
                    markAttendance();
                    break;
                case 3:
                    viewAttendanceHistory();
                    break;
                case 4:
                    requestLeave();
                    break;
                case 5:
                    viewReports();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid Choice...");
            }

        } while (true);
    }

    public static void viewPersonalDetails() {
        scn.nextLine(); // Clear buffer
        System.out.print("Enter your Employee ID: ");
        int empId = scn.nextInt();
        
        EmployeeModel employee = empService.getEmployeeDetailsById(empId);
        if (employee != null) {
            System.out.println("Personal Details:");
            System.out.println("Name: " + employee.getEmployeename());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Gender: " + employee.getGender());
            System.out.println("Salary: " + employee.getSalary());
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void markAttendance() {
        scn.nextLine(); // Clear buffer
        System.out.print("Enter your Employee ID: ");
        int empId = scn.nextInt();
        
        System.out.print("Enter attendance status (Present, Absent, Leave): ");
        String status = scn.next();

        boolean result = attendanceService.markAttendance(empId, status);
        if (result) {
            System.out.println("Attendance marked successfully.");
        } else {
            System.out.println("Failed to mark attendance.");
        }
    }
    
    public static void viewAttendanceHistory() {
        scn.nextLine(); // Clear buffer
        System.out.print("Enter your Employee ID: ");
        int empId = scn.nextInt();
        
        List<AttendanceModel> attendanceHistory = attendanceService.getAttendanceHistory(empId);
        if (attendanceHistory.isEmpty()) {
            System.out.println("No attendance records found.");
        } else {
            System.out.println("Attendance History:");
            for (AttendanceModel attendance : attendanceHistory) {
                System.out.println("Date: " + attendance.getDate() + " | Status: " + attendance.getStatus());
            }
        }
    }
    
    public static void requestLeave() {
        scn.nextLine(); // Clear buffer
        System.out.print("Enter your Employee ID: ");
        int empId = scn.nextInt();
        
        scn.nextLine(); // Clear buffer
        System.out.print("Enter leave reason: ");
        String reason = scn.nextLine();
        
        boolean result = attendanceService.requestLeave(empId, reason);
        if (result) {
            System.out.println("Leave request submitted successfully.");
        } else {
            System.out.println("Failed to submit leave request.");
        }
    }
    
    public static void viewReports() {
        scn.nextLine(); // Clear buffer
        System.out.print("Enter your Employee ID: ");
        int empId = scn.nextInt();
        
        List<AttendanceModel> attendanceReport = attendanceService.getAttendanceReport(empId);
        

        System.out.println("Attendance Report:");
        if (attendanceReport.isEmpty()) {
            System.out.println("No attendance records available.");
        } else {
            for (AttendanceModel attendance : attendanceReport) {
                System.out.println("Date: " + attendance.getDate() + " | Status: " + attendance.getStatus());
            }
        }

        
        }
    }

