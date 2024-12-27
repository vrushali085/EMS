package org.techhub.repository;

import java.util.List;
import org.techhub.model.EmployeeModel;

public interface EmployeeRepository {
    boolean isAddNewEmp(EmployeeModel model);

    List<EmployeeModel> showAllEmployee();

    List<EmployeeModel> getEmployeesByName(String name);

    boolean deleteEmployeeByName(String name);

    boolean updateEmployeeByName(String newName, int age, String gender, int salary, String oldName);

    public EmployeeModel getEmployeeDetailsById(int empId) ;
}
