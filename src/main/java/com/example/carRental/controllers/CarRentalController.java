package com.example.carRental.controllers;

import com.example.carRental.dtos.CarRentalDto;
import com.example.carRental.entities.CarRental;
import com.example.carRental.repositories.BranchRepository;
import com.example.carRental.repositories.CarRentalRepository;
import com.example.carRental.services.BranchService;
import com.example.carRental.services.CarRentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/car_rentals")
public class CarRentalController {

    private CarRentalService carRentalService;

    public CarRentalController(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }

    @PostMapping
    ResponseEntity<CarRentalDto> addCarRental(@RequestBody CarRentalDto carRentalDto) {
        CarRentalDto carRentalDto1 = carRentalService.addCarRental(carRentalDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(carRentalDto1);
    }

    @GetMapping
    ResponseEntity<List<CarRentalDto>> getCarRentals() {
        List<CarRentalDto> carRentalDtoList = carRentalService.getCarRentals();
        return ResponseEntity.ok(carRentalDtoList);
    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<CarRental>> findById(@PathVariable Long id) {
        Optional<CarRental> carRental = carRentalService.findById(id);

        return ResponseEntity.ok(carRental);
    }


    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCarRentalById(@PathVariable Long id) {
        carRentalService.deleteCarRental(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updateCarRentalById(@PathVariable Long id, @RequestBody CarRentalDto carRentalDto) {
        carRentalService.updateCarRentalById(id, carRentalDto);
        return ResponseEntity.noContent().build();
    }

}
