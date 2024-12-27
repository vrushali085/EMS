package org.techhub.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.techhub.model.AttendanceModel;
import org.techhub.model.AttendanceStatus;
import org.techhub.model.EmployeeModel;
import org.techhub.repository.AttendanceRepository;
import org.techhub.repository.AttendanceRepositoryImpl;
import org.techhub.repository.EmployeeRepository;
import org.techhub.repository.EmployeeRepositoryImpl;

public class AttendanceServiceImpl implements AttendanceService {

    private AttendanceRepository attendanceRepo = new AttendanceRepositoryImpl();
    private EmployeeRepository employeeRepo = new EmployeeRepositoryImpl(); // Create a repository instance.
   

    @Override
    public boolean markAttendance(AttendanceModel attendance) {
        return attendanceRepo.markAttendance(attendance);  // Delegate to repository
    }

    @Override
    public List<AttendanceModel> getAttendanceByEmployeeId(int employeeId) {
        return attendanceRepo.getAttendanceByEmployeeId(employeeId);  // Delegate to repository
    }
    public double calculateSalary(int employeeId, LocalDate startDate, LocalDate endDate) {
        
        Map<String, Integer> attendanceSummary = attendanceRepo.getAttendanceSummary(employeeId, startDate, endDate);
        EmployeeModel employee = employeeRepo.getEmployeeById(employeeId);
        System.out.println("Attendance Summary: " + attendanceSummary);
        System.out.println("Employee Salary: " + employee.getSalary());

        if (employee == null) {
            System.out.println("Employee not found.");
            return 0;
        }

        double dailySalary = employee.getSalary() / 30.0; // Assuming 30 days in a month.
        double totalSalary = 0;

       
        for (Map.Entry<String, Integer> entry : attendanceSummary.entrySet()) {
            String status = entry.getKey();
            int count = entry.getValue();

            switch (AttendanceStatus.valueOf(status)) {
                case PRESENT:
                case WORK_FROM_HOME:
                case HOLIDAY:
                    totalSalary += dailySalary * count; // Calculate full salary for these days
                    break;
                case HALF_DAY:
                    totalSalary += (dailySalary / 2) * count; // Half salary for half days
                    break;
                case LATE:
                    totalSalary += dailySalary * count * 0.9; // Deduct 10% for being late
                    break;
                case LEAVE:
                case ABSENT:
                    
                    break;
            }
        }
        
        
        return totalSalary;
    }


}
