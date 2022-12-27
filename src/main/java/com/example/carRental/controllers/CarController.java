package com.example.carRental.controllers;

import com.example.carRental.dtos.CarDto;
import com.example.carRental.entities.Branch;
import com.example.carRental.entities.Car;
import com.example.carRental.repositories.BranchRepository;
import com.example.carRental.repositories.CarRepository;
import com.example.carRental.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BranchRepository branchRepository;

    public CarController(CarService carService, CarRepository carRepository, BranchRepository branchRepository) {
        this.carService = carService;
        this.carRepository = carRepository;
        this.branchRepository = branchRepository;
    }

    @PostMapping
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto carDto) {
        CarDto carDto1 = carService.addCar(carDto);
        return ResponseEntity.status(HttpStatus .CREATED).body(carDto1);
    }
    @GetMapping
    public ResponseEntity<List<CarDto>> getCars(){
        List<CarDto> carDtoList = carService.getCars();
        return ResponseEntity.ok(carDtoList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Car>> getCarById(@PathVariable Long id){
        Optional<Car> car = carService.getCarById(id);
        return ResponseEntity.ok(car);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable Long id){
        carService.deleteCarByid(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCarById(@PathVariable Long id, @RequestBody CarDto carDto){
        carService.updateCarByid(id, carDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{carId}/branch/{branchId}")
    public Car addCarToBranch(@PathVariable Long carId, @PathVariable Long branchId){
        Car car = carRepository.findById(carId).get();
        Branch branch = branchRepository.findById(branchId).get();

        car.setBranch(branch);
        return carRepository.save(car);
    }

}
