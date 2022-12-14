package com.example.carRental.repositories;

import com.example.carRental.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

        Optional<Employee> findByLogin(String login);


}
