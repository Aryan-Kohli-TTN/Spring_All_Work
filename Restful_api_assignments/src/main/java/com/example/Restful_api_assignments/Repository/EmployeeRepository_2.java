package com.example.Restful_api_assignments.Repository;

import com.example.Restful_api_assignments.Entity.Employee_2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository_2 extends JpaRepository<Employee_2,Long> {
}
