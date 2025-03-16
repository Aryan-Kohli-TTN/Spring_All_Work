package com.example.JPA_2_ASSIGNMENT.question_1_2.Repository;

import com.example.JPA_2_ASSIGNMENT.question_1_2.Entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("select firstName , lastName from Employee e where e.salary > (select AVG(e2.salary) from Employee e2 ) order by e.age asc , e.salary desc")
    public List<Object[]> getEmployees_1();

    @Modifying
    @Query("update Employee e set e.salary=:salary where e.salary < :avgSalary")
    public void  update_employee_salary(@Param("salary") Integer salary,@Param("avgSalary") Integer avgSalary);

    @Query("select AVG(e.salary) from Employee e")
    public Integer get_avg_salary();

    @Query("select MIN(e.salary) from Employee e")
    public Integer get_min_salary();

    @Modifying
    @Query("delete Employee e where e.salary = :minSalary")
    public void delete_min_salary(@Param("minSalary") Integer minSalary);


    @Modifying
    @Query(value = "delete from employee where emp_age > :age",nativeQuery = true)
    public void delete_age_greater_than(@Param("age")Integer age);

    @Query(value = "select emp_id,emp_first_name,emp_age from employee where emp_last_name LIKE '%singh'",nativeQuery = true)
    public List<Object[]> get_last_name_singh();
}
