package com.example.Restful_api_assignments.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

public class Employee_2_DTO {
    @Schema(name = "Employee ID", example = "1")
    Long Id;
    @Schema(name = "Employee firstName", example = "Aryan", required = true)
    String firstName;
    @Schema(name = "Employee lastName", example = "Kohli", required = true)
    String lastName;
    @Schema(name = "Employee Age", example = "21", required = true)
    Integer age;
    @Schema(name = "Employee Address", example = "WZ-420 Jammu", required = true)
    String address;
    @Schema(name = "Employee Password", example = "P@ss#word12b@", required = true)
    String password;
    public Employee_2_DTO(){}
    public Employee_2_DTO(Long id, String firstName, String lastName, String address, Integer age, String password) {
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
