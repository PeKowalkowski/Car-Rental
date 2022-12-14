package com.example.carRental.repositories;

import com.example.carRental.entities.Car;
import com.example.carRental.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
   Car findByStatus(Status status);
}
