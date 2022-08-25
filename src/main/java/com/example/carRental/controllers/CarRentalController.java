package com.example.carRental.controllers;

import com.example.carRental.dtos.CarRentalDto;
import com.example.carRental.entities.CarRental;
import com.example.carRental.repositories.BranchRepository;
import com.example.carRental.repositories.CarRentalRepository;
import com.example.carRental.servicesImpl.BranchServiceImpl;
import com.example.carRental.servicesImpl.CarRentalServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car_rentals")
public class CarRentalController {

    private CarRentalServiceImpl carRentalServiceImpl;

    private BranchServiceImpl branchServiceImpl;

    private CarRentalRepository carRentalRepository;

    private BranchRepository branchRepository;

    public CarRentalController(CarRentalServiceImpl carRentalServiceImpl, BranchServiceImpl branchServiceImpl, CarRentalRepository carRentalRepository, BranchRepository branchRepository) {
        this.carRentalServiceImpl = carRentalServiceImpl;

        this.branchServiceImpl = branchServiceImpl;
        this.carRentalRepository = carRentalRepository;
        this.branchRepository = branchRepository;
    }

    @PostMapping
    ResponseEntity<CarRentalDto> addCarRental(@RequestBody CarRentalDto carRentalDto) {
        CarRentalDto carRentalDto1 = carRentalServiceImpl.addCarRental(carRentalDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(carRentalDto1);
    }

    @GetMapping
    ResponseEntity<List<CarRentalDto>> getCarRentals(){
        List<CarRentalDto> carRentalDtoList = carRentalServiceImpl.getCarRentals();
        return ResponseEntity.ok(carRentalDtoList);
        /*return ResponseEntity.ok(carRentalServiceImpl.getCarRentals());*/
    }
    @GetMapping("/{id}")
    ResponseEntity<CarRental> findById(@PathVariable Long id){
    CarRental carRental = carRentalServiceImpl.findById(id);
    return ResponseEntity.ok(carRental);
    }



    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCarRentalById(@PathVariable Long id){
        carRentalServiceImpl.deleteCarRental(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    ResponseEntity<Void> updateCarRentalById(@PathVariable Long id, @RequestBody CarRentalDto carRentalDto){
    carRentalServiceImpl.updateCarRentalById(id, carRentalDto);
    return ResponseEntity.noContent().build();
    }

}
