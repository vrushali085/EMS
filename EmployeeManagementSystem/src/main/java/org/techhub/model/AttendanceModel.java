package org.techhub.model;

import java.time.LocalDate;

public class AttendanceModel {
    private int attendanceId;
    private int employeeId;
    private LocalDate adate;  // Date the attendance was marked
    private String status;  // Status (e.g., 'Present', 'Absent', 'Leave', etc.)
    private boolean isVerified;
    private Integer verifiedBy;  // Employee ID of the person who verified
    private boolean isMarked;

    // Default constructor
    public AttendanceModel() {}

    // Constructor with all fields
    public AttendanceModel(int attendanceId, int employeeId, LocalDate adate, String status, boolean isVerified, 
                           Integer verifiedBy, boolean isMarked) {
        this.attendanceId = attendanceId;
        this.employeeId = employeeId;
        this.adate = adate;
        this.status = status;
        this.isVerified = isVerified;
        this.verifiedBy = verifiedBy;
        this.isMarked = isMarked;
    }

    // Getters and Setters
    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getAdate() {
        return adate;
    }

    public void setAdate(LocalDate adate) {
        this.adate = adate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public Integer getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(Integer verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean isMarked) {
        this.isMarked = isMarked;
    }

    @Override
    public String toString() {
        return "AttendanceModel{" +
                "attendanceId=" + attendanceId +
                ", employeeId=" + employeeId +
                ", adate=" + adate +
                ", status='" + status + '\'' +
                ", isVerified=" + isVerified +
                ", verifiedBy=" + verifiedBy +
                ", isMarked=" + isMarked +
                '}';
    }
}
