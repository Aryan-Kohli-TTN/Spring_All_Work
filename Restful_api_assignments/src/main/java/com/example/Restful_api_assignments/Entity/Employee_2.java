package com.example.Restful_api_assignments.Entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity(name="Employee2")
public class Employee_2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "firstName")
    @NotBlank(message = "firstName Cannot be blank")
    String firstName;

    @Column(name = "lastName")
    @NotBlank(message = "lastName Cannot be blank")
    String lastName;

    @Column(name = "address")
    @NotBlank(message = "address Cannot be blank")
    String address;

    @Column(name="age")
    Integer age;

    @Column(name="password")
    @JsonIgnore
    String password;
    public Employee_2(){}
    public Employee_2(Long id, String firstName, String lastName, String address, Integer age, String password) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.password = password;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee_2{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Address='" + address + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
