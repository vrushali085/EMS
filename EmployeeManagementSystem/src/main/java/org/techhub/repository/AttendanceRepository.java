
	package org.techhub.repository;



	import org.techhub.model.AttendanceModel;

	import java.sql.SQLException;
	import java.util.List;

	public interface AttendanceRepository {

	    // Save or update attendance record (Insert or Update)
	    void saveAttendance(AttendanceModel attendance) throws SQLException;

	    // Retrieve attendance by employee ID
	    List<AttendanceModel> getAttendanceByEmployeeId(int employeeId) throws SQLException;

	    // Retrieve attendance by date
	    List<AttendanceModel> getAttendanceByDate(String date) throws SQLException;

	    // Delete attendance by ID
	    void deleteAttendance(int id) throws SQLException;
	}



