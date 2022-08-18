package com.example.carRental.controllers;

import com.example.carRental.dtos.CarRentalDto;
import com.example.carRental.entities.CarRental;
import com.example.carRental.servicesImpl.CarRentalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/car_rentals")
public class CarRentalController {

    @Autowired
    private CarRentalServiceImpl carRentalServiceImpl;

    public CarRentalController(CarRentalServiceImpl carRentalServiceImpl) {
        this.carRentalServiceImpl = carRentalServiceImpl;
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
    ResponseEntity<Optional<CarRental>> findById(@PathVariable Long id){
    Optional<CarRental> carRentalDto = carRentalServiceImpl.findById(id);
    return ResponseEntity.ok(carRentalDto);
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
