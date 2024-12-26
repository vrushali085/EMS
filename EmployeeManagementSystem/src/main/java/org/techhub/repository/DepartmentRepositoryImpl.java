package org.techhub.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.techhub.model.DepartmentModel;

public class DepartmentRepositoryImpl extends DBSTATE implements DepartmentRepository {

	@Override
	public boolean addNewDepartment(DepartmentModel department) {
		try {
            stmt = conn.prepareStatement("INSERT INTO department (name, location) VALUES (?, ?)");
            stmt.setString(1, department.getName());
            stmt.setString(2, department.getLocation());

            int value = stmt.executeUpdate();
            return value > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public List<DepartmentModel> showAllDepartments() {
		List<DepartmentModel> departmentList = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT * FROM department");
            rs = stmt.executeQuery();

            while (rs.next()) {
                DepartmentModel department = new DepartmentModel();
                department.setDepartment_id(rs.getInt("department_id"));
                department.setName(rs.getString("name"));
                department.setLocation(rs.getString("location"));

                departmentList.add(department);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departmentList;
	}

	@Override
	public List<DepartmentModel> getDepartmentByName(String name) {
		List<DepartmentModel> departmentList = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("");
            stmt.setString(1, "%" + name + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                DepartmentModel department = new DepartmentModel();
                department.setDepartment_id(rs.getInt("department_id"));
                department.setName(rs.getString("name"));
                department.setLocation(rs.getString("location"));

                departmentList.add(department);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departmentList;
	}

	@Override
	public boolean deleteDepartmentByName(String name) {
		try {
            stmt = conn.prepareStatement("DELETE FROM department WHERE name = ?");
            stmt.setString(1, name);
            int value = stmt.executeUpdate();
            return value > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean updateDepartmentByName(String newName, String newLocation, String oldName) {
		try {
            stmt = conn.prepareStatement("UPDATE department SET name = ?, location = ? WHERE name = ?");
            stmt.setString(1, newName);
            stmt.setString(2, newLocation);
            stmt.setString(3, oldName);

            int value = stmt.executeUpdate();
            return value > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
	}

}
