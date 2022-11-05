package com.example.carRental.repositories;

import com.example.carRental.entities.Company;
import com.example.carRental.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByLogin(String login);

    @Query(value = "SELECT * FROM companies WHERE address_id = '?1'" , nativeQuery = true)
    List<Company> findByAddress_Id(Long id);
}
