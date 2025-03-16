package com.example.Restful_api_assignments;

import com.example.JPA_2_ASSIGNMENT.question4.Employee_2;
import com.example.JPA_2_ASSIGNMENT.question4.Employee_2_repository;
import com.example.JPA_2_ASSIGNMENT.question4.SalaryDetails;
import com.example.Restful_api_assignments.Entity.Employee;
import com.example.Restful_api_assignments.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Random;

@SpringBootTest
class RestfulApiAssignmentsApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void test_findByName(){
		List<Employee> employee = employeeRepository.findByName("Aryan");
		System.out.println(employee);
	}
	@Test
	void updateEmployee(){
		Employee employee = employeeRepository.findById(2L).get();
		employee.setName("Anshu");
		employee.setAge(19);
		employee.setLocation("up");
		employee.setPassword("noPass");
		employeeRepository.save(employee);
	}
	@Test
	void test_saveEmployee(){
		Employee  employee = new Employee();
		employee.setName("Aryan");
		employee.setAge(21);
		employee.setLocation("Delhi");
		employee.setPassword("Pass");
		employeeRepository.save(employee);
	}
	@Test
	void test_saveManyEmployee(){
		Random random = new Random();
		for(int i=0;i<10;i++){
			Employee  employee = new Employee();
			employee.setName(i+" name");
			employee.setAge(random.nextInt(100));
			employee.setLocation(i+" Loc.");
			employee.setPassword(i+"Pass");
			employeeRepository.save(employee);
		}
	}
	@Test
	void test_readAll(){
		List<Employee> employees = employeeRepository.findAll();
		employees.forEach(System.out::println);
	}
	@Test
	void test_paging_sort_age(){
		Page<Employee> employees = employeeRepository.findAll(PageRequest.of(2,4, Sort.by("age")));
		employees.getContent().forEach(System.out::println);
	}
	@Test
	void test_countEmployee(){
		System.out.println(employeeRepository.count());
	}

	@Test
	void test_findByNameStartsWith(){
		List<Employee> employees = employeeRepository.findByNameStartsWith("A");
		employees.forEach(System.out::println);
	}

	@Test
	void test_findByAgeBetween(){
		List<Employee> employees = employeeRepository.findByAgeBetween(28,32);
		employees.forEach(System.out::println);
	}


}
