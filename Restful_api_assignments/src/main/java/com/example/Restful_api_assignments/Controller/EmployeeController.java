package com.example.Restful_api_assignments.Controller;

import com.example.Restful_api_assignments.Entity.Employee;
import com.example.Restful_api_assignments.Exceptions.UserNotFoundException;
import com.example.Restful_api_assignments.Repository.EmployeeRepository;
import com.example.Restful_api_assignments.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping("/test")
    public String testApi(){
        return "Welcome Spring Boot!";
    }

    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getAllEmployeeById(@PathVariable Long id){
        Employee employee= employeeService.getEmployeeById(id);
        if(employee==null)
            throw new UserNotFoundException("User not found with id "+id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @DeleteMapping ("/employees/{id}")
    public ResponseEntity<String> deleteEmployees(@PathVariable Long id){
        employeeService.removeEmployeeById(id);
        return new ResponseEntity<>("Employee Removed", HttpStatus.OK);
    }
    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployees(@Valid @RequestBody Employee employee){
        Employee employee1=employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        Employee employee1 = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }
    @PostMapping("/employees/all")
    public ResponseEntity<List<Employee>> saveEmployee(@Valid @RequestBody List<Employee> employees){
        List<Employee> employee1 = employeeService.addAllEmployees(employees);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }
}
