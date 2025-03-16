package com.example.JPA_2_ASSIGNMENT.question3.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue(value = "BIKE")
@PrimaryKeyJoinColumn(name = "id")
public class Bike extends Vehicle{
    String bike_property;

    public Bike(){}
    public Bike(String bike_property) {
        this.bike_property = bike_property;
    }

    public Bike(String vehicle_no, String bike_property) {
        super(vehicle_no);
        this.bike_property = bike_property;
    }

    public String getBike_property() {
        return bike_property;
    }

    public void setBike_property(String bike_property) {
        this.bike_property = bike_property;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "bike_property='" + bike_property + '\'' +
                ", id=" + id +
                ", vehicle_no='" + vehicle_no + '\'' +
                '}';
    }
}
