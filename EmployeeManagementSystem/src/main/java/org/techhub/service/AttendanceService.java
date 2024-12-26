
	package org.techhub.service;

	import org.techhub.model.AttendanceModel;
	import java.util.List;

	public interface AttendanceService {
	    boolean markAttendance(int empId, String status);
	    List<AttendanceModel> getAttendanceHistory(int empId);
	    boolean requestLeave(int empId, String reason);
	    List<AttendanceModel> getAttendanceReport(int empId);
	}


