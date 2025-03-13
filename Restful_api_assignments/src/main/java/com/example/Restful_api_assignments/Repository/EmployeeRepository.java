package com.example.Restful_api_assignments.Repository;

import com.example.Restful_api_assignments.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByName(String name);
    List<Employee> findByNameStartsWith(String s);

    @Query("from Employee where age >= :min_age and age <=:max_age")
    List<Employee> findByAgeBetween(@Param("min_age") int min_age,@Param("max_age") int max_age);
}
