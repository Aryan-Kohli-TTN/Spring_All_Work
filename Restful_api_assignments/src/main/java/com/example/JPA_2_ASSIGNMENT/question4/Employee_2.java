package com.example.JPA_2_ASSIGNMENT.question4;

import jakarta.persistence.*;

@Entity
public class Employee_2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String firstName;
    String lastName;
    Integer age;

    @Embedded
    SalaryDetails salaryDetails;

    public Employee_2() {
    }

    public Employee_2(String firstName, String lastName, Integer age, SalaryDetails salaryDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salaryDetails = salaryDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SalaryDetails getSalaryDetails() {
        return salaryDetails;
    }

    public void setSalaryDetails(SalaryDetails salaryDetails) {
        this.salaryDetails = salaryDetails;
    }

    @Override
    public String toString() {
        return "Employee_2{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salaryDetails=" + salaryDetails +
                '}';
    }
}
