package org.techhub.repository;

import org.techhub.model.AttendanceModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceRepositoryImpl extends DBSTATE implements AttendanceRepository {

    // Connection parameters (replace with your DB connection details)
    private static final String URL = "jdbc:mysql://localhost:3306/empdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Create connection
    private Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Database connection error.");
        }
    }

    // Save or update attendance (Insert or Update)
    @Override
    public void saveAttendance(AttendanceModel attendance) throws SQLException {
        String query = "INSERT INTO attendance (employee_id, date, is_verified, status, verified_by, is_marked) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set parameters for the query
            stmt.setInt(1, attendance.getEmpId());
            stmt.setString(2, attendance.getDate());
            stmt.setBoolean(3, attendance.getis_verified());
            stmt.setString(4, attendance.getStatus());
            stmt.setString(5, attendance.getverified_by());
            stmt.setInt(6, attendance.getis_marked());

            // Execute the query
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error inserting attendance record");
        }
    }

    // Retrieve attendance by employee ID
    @Override
    public List<AttendanceModel> getAttendanceByEmployeeId(int employeeId) throws SQLException {
        String query = "SELECT * FROM attendance WHERE employee_id = ?";
        List<AttendanceModel> attendanceList = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();

            // Loop through the result set and populate the list
            while (rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("date");
                boolean isVerified = rs.getBoolean("is_verified");
                String status = rs.getString("status");
                String verifiedBy = rs.getString("verified_by");
                int isMarked = rs.getInt("is_marked");

                attendanceList.add(new AttendanceModel(id, employeeId, date, isVerified, status, isMarked));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error retrieving attendance by employee ID");
        }
        return attendanceList;
    }

    // Retrieve attendance by date
    @Override
    public List<AttendanceModel> getAttendanceByDate(String date) throws SQLException {
        String query = "SELECT * FROM attendance WHERE date = ?";
        List<AttendanceModel> attendanceList = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();

            // Loop through the result set and populate the list
            while (rs.next()) {
                int id = rs.getInt("id");
                int employeeId = rs.getInt("employee_id");
                boolean isVerified = rs.getBoolean("is_verified");
                String status = rs.getString("status");
                String verifiedBy = rs.getString("verified_by");
                int isMarked = rs.getInt("is_marked");

                attendanceList.add(new AttendanceModel(id, employeeId, date, isVerified, status, isMarked));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error retrieving attendance by date");
        }
        return attendanceList;
    }

    // Delete attendance by ID
    @Override
    public void deleteAttendance(int id) throws SQLException {
        String query = "DELETE FROM attendance WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error deleting attendance record");
        }
    }
}
