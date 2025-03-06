package com.example.Restful_api_assignments.Repository;

import com.example.Restful_api_assignments.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
