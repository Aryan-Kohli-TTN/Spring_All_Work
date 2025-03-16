package com.example.JPA_2_ASSIGNMENT.question3.Entity;

import jakarta.persistence.*;

@Entity
//@DiscriminatorValue(value = "CAR")
@PrimaryKeyJoinColumn(name = "id")
public class Car extends Vehicle {

    String car_property;
    public Car(String car_property) {
        this.car_property = car_property;
    }

    public Car(String vehicle_no, String car_property) {
        super(vehicle_no);
        this.car_property = car_property;
    }

    public String getCar_property() {
        return car_property;
    }

    public void setCar_property(String car_property) {
        this.car_property = car_property;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_property='" + car_property + '\'' +
                ", id=" + id +
                ", vehicle_no='" + vehicle_no + '\'' +
                '}';
    }
}
