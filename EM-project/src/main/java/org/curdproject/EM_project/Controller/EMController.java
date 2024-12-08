package org.curdproject.EM_project.Controller;

import java.util.List;

import org.curdproject.EM_project.Model.Employee;
import org.curdproject.EM_project.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EMController {
    //List<Employee>employees=new ArrayList<>();
    
    @Autowired
    EmployeeServices employeeServices;
    @GetMapping("employee")
    public List<Employee> getAllEmployee(){
        return employeeServices.readEmployee();
    }
    @GetMapping("employee/{Id}")
    public Employee getEmployeeById(@PathVariable Long Id){
        return employeeServices.readEmployeeID(Id);
    }
    @PostMapping("employee")
    public String postMethodName(@RequestBody Employee employee) {
        
        employeeServices.creatEmployee(employee);
        return "Post Succefully";
    }
    @DeleteMapping("employee/{Id}")
    public String deletEmployee(@PathVariable Long Id){
        if(employeeServices.deletEmployee(Id))
            return "delet Succfully";
        
        return "not found";
    }
    @PutMapping("employee/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {

        
        
        return employeeServices.updateEmployee(id, employee);
    }
    

}
//Controller Layer:

//Receives an HTTP request, such as POST /api/employees.
//Passes data (as Employee) to the Service Layer.

//Service Layer:

//Maps the data from Employee to EmployeeEntity.
//Calls the Repository Layer to save or retrieve data.

//Repository Layer:

//Uses JpaRepository to store or fetch data from the database.
//Returns results (e.g., a saved EmployeeEntity) to the Service Layer.

//Service Layer:

//Converts EmployeeEntity back to Employee (if needed).
//Returns the result to the Controller Layer.

//Controller Layer:
//Sends the result as an HTTP response to the client.