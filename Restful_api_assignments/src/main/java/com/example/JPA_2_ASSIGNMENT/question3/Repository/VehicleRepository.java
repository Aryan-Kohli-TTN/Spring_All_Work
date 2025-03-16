package com.example.JPA_2_ASSIGNMENT.question3.Repository;

import com.example.JPA_2_ASSIGNMENT.question3.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
