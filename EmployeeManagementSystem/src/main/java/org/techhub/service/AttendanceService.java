package org.techhub.service;

import java.time.LocalDate;
import java.util.List;
import org.techhub.model.AttendanceModel;

public interface AttendanceService {
    boolean markAttendance(AttendanceModel attendance);
    List<AttendanceModel> getAttendanceByEmployeeId(int employeeId);
    public double calculateSalary(int employeeId, LocalDate startDate, LocalDate endDate);
}
