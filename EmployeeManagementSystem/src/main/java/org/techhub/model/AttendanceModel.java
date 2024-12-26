package org.techhub.model;

public class AttendanceModel {
    private int empId;
    private String date;
    private String status;
    private boolean is_verified;
    private String verified_by;
    private int is_marked;

    public AttendanceModel(int id, int employeeId, String date2, boolean is_verified,String verified_by,int is_marked) {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public boolean getis_verified() {
    	return is_verified;
    }
    public void setis_verified(boolean is_verified) {
    	this.is_verified = is_verified;
    }
    public String getverified_by(){
    	return verified_by;
    }
    public void setverified_by(String verified_by) {
    	this.verified_by = verified_by;
    }
    public int getis_marked() {
    	return is_marked;
    }
    public void setis_marked(int is_marked) {
    	this.is_marked = is_marked;
    }

	public int getemployee_id() {
		// TODO Auto-generated method stub
		return 0;
	}
}
