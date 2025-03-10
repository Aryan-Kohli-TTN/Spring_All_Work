package com.example.Restful_api_assignments.DTO;

import com.fasterxml.jackson.annotation.JsonFilter;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonFilter("filter1")
public class EmployeeDTO {

    @Schema(name = "Employee ID", example = "1")
    Long Id;
    @Schema(name = "Employee Name", example = "Aryan Kohli", required = true)
    String name;
    @Schema(name = "Employee Age", example = "21", required = true)
    Integer age;
    @Schema(name = "Employee Password", example = "P@ss#word12b@", required = true)
    String password;

    public EmployeeDTO(){}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeDTO(Long id, String name, Integer age, String password) {
        Id = id;
        this.name = name;
        this.age = age;
        this.password=password;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
