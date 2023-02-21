package com.example.carRental.repositories;

import com.example.carRental.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("select c from Car c where c.brand =:b")
    public List<Car> getCarByBrand(@Param("b")String brand);

    @Query("select c from Car c where c.model =:m")
    public List<Car> getCarByModel(@Param("m") String model);

    @Query("select c from Car c where c.year =:y")
    public List<Car> getCarByYear(@Param("y")String year);

    @Query("select c from Car c where c.price =:p")
    public List<Car> getCarByPrice(@Param("p") String price);
    
    @Query("SELECT c.id, b.name, c.model FROM Car c INNER JOIN Branch b ON c.branch.id = b.id where b.name =:bn")
    public List<Car> getByBranch(@Param("bn") String bn);


}
