package org.curdproject.EM_project.Services;


import java.util.List;

import org.curdproject.EM_project.Model.Employee;
import org.springframework.stereotype.Service;

@Service    //service is used to implement bussiness logic .
//creating an EmployeeEntity from Employee and saving it using RepositoryEmployee
public interface EmployeeServices {
    String creatEmployee(Employee employee);
    List<Employee> readEmployee();
    boolean deletEmployee(long Id);
    String updateEmployee(long Id,Employee employee);
    Employee readEmployeeID(long Id);
   

}
//It interacts with the RepositoryEmployee to perform operations and
// handle logic before returning data to the controller.