package com.example.carRental.repositories;

import com.example.carRental.entities.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental, Long> {

    /*@Query(value = "update car_rentals set name = ?1, website = ?2, phoneNumber = ?3, owner = ?4 where id = ?5", nativeQuery = true)
    void updateCarRental(Long id,String name, String website, String phoneNumber, String owner);

    @Query(value = "SELECT * FROM car_rentals as b WHERE b.id=?1", nativeQuery = true)
    CarRental getCarRentalsById(Long id);
*/
}
