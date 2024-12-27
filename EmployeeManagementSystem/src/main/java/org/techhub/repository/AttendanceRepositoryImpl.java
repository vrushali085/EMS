package org.techhub.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.techhub.model.AttendanceModel;

public class AttendanceRepositoryImpl extends DBSTATE implements AttendanceRepository {

	public boolean markAttendance(AttendanceModel attendance) {
	    String query = "INSERT INTO attendance (employee_id, adate, status, is_verified, verified_by, is_marked) " +
	                   "VALUES (?, ?, ?, ?, ?, ?)";
	    try {
	        if (conn == null || conn.isClosed()) {
	            System.out.println("Connection is not established or closed.");
	            return false;
	        }

	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, attendance.getEmployeeId());
	        stmt.setDate(2, Date.valueOf(attendance.getAdate()));  // Convert LocalDate to SQL Date
	        stmt.setString(3, attendance.getStatus());
	        stmt.setBoolean(4, attendance.isVerified());
	        stmt.setObject(5, attendance.getVerifiedBy(), Types.INTEGER);  // Set null if not verified
	        stmt.setBoolean(6, attendance.isMarked());

	        int rowsInserted = stmt.executeUpdate();
	        return rowsInserted > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

    @Override
    public List<AttendanceModel> getAttendanceByEmployeeId(int employeeId) {
        List<AttendanceModel> employeeAttendance = new ArrayList<>();
        String query = "SELECT * FROM attendance WHERE employee_id = ?";
        
        try {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, employeeId);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int attendanceId = rs.getInt("attendance_id");
                int empId = rs.getInt("employee_id");
                Date date = rs.getDate("adate");
                String status = rs.getString("status");
                boolean isVerified = rs.getBoolean("is_verified");  // Retrieving as boolean (converts from tinyint(1))
                Integer verifiedBy = rs.getInt("verified_by");
                boolean isMarked = rs.getBoolean("is_marked");  // Retrieving as boolean (converts from tinyint(1))

                // Add the attendance record to the list
                AttendanceModel attendance = new AttendanceModel(attendanceId, empId, date.toLocalDate(), status, isVerified, 
                                                                 verifiedBy == 0 ? null : verifiedBy, isMarked);
                employeeAttendance.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return employeeAttendance;
    }
    
    public Map<String, Integer> getAttendanceSummary(int employeeId, LocalDate startDate, LocalDate endDate) {
        String query = "SELECT status, COUNT(*) as count " +
                       "FROM attendance " +
                       "WHERE employee_id = ? AND adate BETWEEN ? AND ? " +
                       "GROUP BY status";

        Map<String, Integer> attendanceSummary = new HashMap<>();
        try {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, employeeId);
            stmt.setDate(2, Date.valueOf(startDate));
            stmt.setDate(3, Date.valueOf(endDate));
            rs = stmt.executeQuery();

            while (rs.next()) {
                attendanceSummary.put(rs.getString("status"), rs.getInt("count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceSummary;
    }


}
