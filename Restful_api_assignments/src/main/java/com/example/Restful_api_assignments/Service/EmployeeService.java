package com.example.Restful_api_assignments.Service;

import com.example.Restful_api_assignments.Entity.Employee;
import com.example.Restful_api_assignments.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployee(){
            return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id){
            return employeeRepository.findById(id).orElse(null);
    }
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> addAllEmployees(List<Employee> employees){
        return employeeRepository.saveAll(employees);
    }
    public void removeEmployeeById(Long id){
            employeeRepository.deleteById(id);
    }
    public Employee updateEmployee(Employee employee){
        Employee oldEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        if(oldEmployee==null)
            return null;
        if(employee.getAge()!=null)
            oldEmployee.setAge(employee.getAge());
        if(employee.getName()!=null)
            oldEmployee.setName(employee.getName());
        return employeeRepository.save(oldEmployee);
    }
}
