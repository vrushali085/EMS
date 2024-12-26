package org.techhub.repository;

import java.util.List;

import org.techhub.model.DepartmentModel;

public interface DepartmentRepository {
	boolean addNewDepartment(DepartmentModel department);

    List<DepartmentModel> showAllDepartments();

    List<DepartmentModel> getDepartmentByName(String name);

    boolean deleteDepartmentByName(String name);

    boolean updateDepartmentByName(String newName, String newLocation, String oldName);
	

}
