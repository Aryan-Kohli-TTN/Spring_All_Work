package com.example.Restful_api_assignments.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "name")
    @NotBlank(message = "Name Cannot be blank")
    String name;

    @Column(name="age")
    Integer age;
    public Employee(){}
    public Employee(Long id, String name, Integer age) {
        Id = id;
        this.name = name;
        this.age = age;
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
                '}';
    }
}
