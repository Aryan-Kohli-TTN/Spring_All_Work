package com.example.JPA_2_ASSIGNMENT;

import com.example.JPA_2_ASSIGNMENT.question3.Entity.Bike;
import com.example.JPA_2_ASSIGNMENT.question3.Repository.VehicleRepository;
import com.example.JPA_2_ASSIGNMENT.question4.Employee_2;
import com.example.JPA_2_ASSIGNMENT.question4.Employee_2_repository;
import com.example.JPA_2_ASSIGNMENT.question4.SalaryDetails;
import com.example.JPA_2_ASSIGNMENT.question_1_2.Entity.Employee;
import com.example.JPA_2_ASSIGNMENT.question_1_2.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@SpringBootTest
class JPA_2_ASSIGNMENTTests {
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	Employee_2_repository employee2Repository;
	@Test
	public  void getEmployee(){
		List<Object[]> employees = employeeRepository.getEmployees_1();
		employees.forEach((e)-> System.out.println(e[0]+"  "+e[1]));
	}
	@Test
	public void get_avg_salary(){
		System.out.println(employeeRepository.get_avg_salary());
	}
	@Test
	public void save_employees(){
		Random age_random = new Random();
		Random salary_random = new Random();
		for(int i=0;i<15;i++){
			Employee employee = new Employee();
			employee.setFirstName("firstName"+i);
			employee.setLastName("lastName"+i);
			employee.setAge(age_random.nextInt(100));
			employee.setSalary(salary_random.nextInt(1000));
			employeeRepository.save(employee);
		}
	}
	@Test
	@Transactional
	@Rollback(value = false)
	public void update_salary(){
		employeeRepository.update_employee_salary(employeeRepository.get_avg_salary(),employeeRepository.get_avg_salary());
	}
	@Test
	@Transactional
	@Rollback(value = false)
	public void delete_min_salary(){
		employeeRepository.delete_min_salary(employeeRepository.get_min_salary());
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void delete_age_greater_than(){
		employeeRepository.delete_age_greater_than(45);
	}

	@Test
	public void get_last_name_singh(){
		List<Object[]> employees =employeeRepository.get_last_name_singh();
		employees.forEach((emp)-> System.out.println(emp[0]+"  "+emp[1]+"  "+emp[2]));
	}

	@Test
	public void save_bike(){
		Bike bike = new Bike();
		bike.setVehicle_no("1982912i");
		bike.setBike_property("Bike");
		vehicleRepository.save(bike);
	}

	@Test
	void add_employee_2(){
		Employee_2 employee2 = new Employee_2();
		employee2.setFirstName("Aryan");
		employee2.setLastName("Kohli");
		employee2.setAge(21);
		SalaryDetails salaryDetails = new SalaryDetails();
		salaryDetails.setBasicSalary(90000F);
		salaryDetails.setBonusSalary(2121F);
		salaryDetails.setTaxAmount(2100F);
		salaryDetails.setSpecialAllowanceSalary(9000F);
		employee2.setSalaryDetails(salaryDetails);
		employee2Repository.save(employee2);
	}
}
