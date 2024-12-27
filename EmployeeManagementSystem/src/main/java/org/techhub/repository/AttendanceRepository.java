package org.techhub.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.techhub.model.AttendanceModel;

public interface AttendanceRepository {
    boolean markAttendance(AttendanceModel attendance);
    List<AttendanceModel> getAttendanceByEmployeeId(int employeeId);
    public Map<String, Integer> getAttendanceSummary(int employeeId, LocalDate startDate, LocalDate endDate);
}
