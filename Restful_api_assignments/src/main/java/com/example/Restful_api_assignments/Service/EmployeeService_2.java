package com.example.Restful_api_assignments.Service;

import com.example.Restful_api_assignments.Entity.Employee;
import com.example.Restful_api_assignments.Entity.Employee_2;
import com.example.Restful_api_assignments.Repository.EmployeeRepository_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService_2 {
    @Autowired
    EmployeeRepository_2 employeeRepository_2;


    public List<Employee_2> getAllEmployee(){
            return employeeRepository_2.findAll();
    }
    public Employee_2 getEmployeeById(Long id){
            return employeeRepository_2.findById(id).orElse(null);
    }
    public Employee_2 addEmployee(Employee_2 employee){
        return employeeRepository_2.save(employee);
    }
    public List<Employee_2> addAllEmployees(List<Employee_2> employees){
        return employeeRepository_2.saveAll(employees);
    }
    public void removeEmployeeById(Long id){
            employeeRepository_2.deleteById(id);
    }
    public Employee_2 updateEmployee(Employee_2 employee){
        Employee_2 oldEmployee = employeeRepository_2.findById(employee.getId()).orElse(null);
        if(oldEmployee==null)
            return null;
        if(employee.getAge()!=null)
            oldEmployee.setAge(employee.getAge());
        if(employee.getFirstName()!=null)
            oldEmployee.setFirstName(employee.getFirstName());
        if(employee.getLastName()!=null)
            oldEmployee.setLastName(employee.getLastName());
        if(employee.getAddress()!=null)
            oldEmployee.setAddress(employee.getAddress());
        return employeeRepository_2.save(oldEmployee);
    }
}
