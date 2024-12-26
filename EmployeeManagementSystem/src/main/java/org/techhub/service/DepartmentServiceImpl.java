package org.techhub.service;

import java.util.List;
import org.techhub.model.DepartmentModel;
import org.techhub.repository.DBSTATE;
import org.techhub.repository.DepartmentRepository;
import org.techhub.repository.DepartmentRepositoryImpl;

public class DepartmentServiceImpl  implements DepartmentService {

	DepartmentRepository deptRepo = new DepartmentRepositoryImpl();
	
    @Override
    public boolean addNewDepartment(DepartmentModel department) {
        return deptRepo.addNewDepartment(department);
    }

    @Override
    public List<DepartmentModel> showAllDepartments() {
        return deptRepo.showAllDepartments();
    }

    @Override
    public List<DepartmentModel> getDepartmentByName(String name) {
        return deptRepo.getDepartmentByName(name);
    }

    @Override
    public boolean deleteDepartmentByName(String name) {
        return deptRepo.deleteDepartmentByName(name);
    }

    @Override
    public boolean updateDepartmentByName(String newName, String newLocation, String oldName) {
        return deptRepo.updateDepartmentByName(newName, newLocation, oldName);
    }
}
