package org.curdproject.EM_project.Services;

import java.util.ArrayList;
import java.util.List;

import org.curdproject.EM_project.Entity.EmployeeEntity;
import org.curdproject.EM_project.Model.Employee;
import org.curdproject.EM_project.Repository.RepositoryEmployee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeeServicesImpl implements EmployeeServices {
    @Autowired
    private RepositoryEmployee  repositoryemployee;

    @Override
    public String creatEmployee(Employee employee) {
        EmployeeEntity employeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity); //Copies properties from one object to another.
        // Useful for mapping data between DTOs (Data Transfer Objects, like Employee) and entity objects (EmployeeEntity).
        repositoryemployee.save(employeeEntity);
        
        return "Employee created successfully";
    }

    @Override
    public List<Employee> readEmployee() {
        List<EmployeeEntity>employeeList=new ArrayList<>();
        List<Employee>employees=new ArrayList<>();
        for(EmployeeEntity employeeEntity:employeeList){
             Employee emp=new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmailId(employeeEntity.getEmailId());
            emp.setPhonenumber(employeeEntity.getPhonenumber());
            employees.add(emp);
        }
           
        
        return employees;
    }

    @Override
    public boolean deletEmployee(long Id) {
       EmployeeEntity emp=repositoryemployee.findById(Id).get();
       repositoryemployee.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(long Id, Employee employee) {
        EmployeeEntity exestingEmployee=repositoryemployee.findById(Id).get();
        exestingEmployee.setName(employee.getName());
        exestingEmployee.setEmailId(employee.getEmailId());
        exestingEmployee.setPhonenumber(employee.getPhonenumber());
        repositoryemployee.save(exestingEmployee);
        return "update Sucefully";
    }

    @Override
    public Employee readEmployeeID(long Id) {
        EmployeeEntity employeeEntity=repositoryemployee.findById(Id).get();
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeEntity,employee );        
       return employee;
    }
}
