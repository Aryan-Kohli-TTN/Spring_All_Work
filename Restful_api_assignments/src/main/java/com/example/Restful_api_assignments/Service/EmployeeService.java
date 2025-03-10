package com.example.Restful_api_assignments.Service;

import com.example.Restful_api_assignments.DTO.EmployeeDTO;
import com.example.Restful_api_assignments.Entity.Employee;
import com.example.Restful_api_assignments.Exceptions.UserNotFoundException;
import com.example.Restful_api_assignments.Repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public MappingJacksonValue getFilteredEmployees(Long id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee==null)
            throw new UserNotFoundException("Employee not Found");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee,employeeDTO);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employeeDTO);
        SimpleBeanPropertyFilter filter1 = SimpleBeanPropertyFilter.filterOutAllExcept("name","Id");
        FilterProvider filters = new SimpleFilterProvider().addFilter("filter1",filter1);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

}
