package com.example.JPA_2_ASSIGNMENT.question3.Entity;

import jakarta.persistence.*;

@Entity
// for single table
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "Vehicle_type")

// for table per class
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

// for joined
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String vehicle_no;

    public Vehicle() {
    }

    public Vehicle(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicle_no='" + vehicle_no + '\'' +
                '}';
    }
}
