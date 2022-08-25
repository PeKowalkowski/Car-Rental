package com.example.carRental.repositories;

import com.example.carRental.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    /*@Query(value = "SELECT * FROM branches as b WHERE b.id=?1", nativeQuery = true)
    Branch getById(Long id);*/
}
