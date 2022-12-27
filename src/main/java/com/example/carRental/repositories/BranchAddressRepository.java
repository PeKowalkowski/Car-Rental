package com.example.carRental.repositories;

import com.example.carRental.entities.BranchAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchAddressRepository extends JpaRepository<BranchAddress, Long> {
}
