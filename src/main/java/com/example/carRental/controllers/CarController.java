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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {


    private CarService carService;


    private CarRepository carRepository;


    private BranchRepository branchRepository;

    public CarController(CarService carService, CarRepository carRepository, BranchRepository branchRepository) {
        this.carService = carService;
        this.carRepository = carRepository;
        this.branchRepository = branchRepository;
    }

    @PostMapping
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto carDto) {
        CarDto carDto1 = carService.addCar(carDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(carDto1);
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getCars() {
        List<CarDto> carDtoList = carService.getCars();
        return ResponseEntity.ok(carDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Car>> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.getCarById(id);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Car>> getCarByBrand(@PathVariable String brand) {
        List<Car> carList = carService.getCarByBrand(brand);
        return ResponseEntity.ok(carList);
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<Car>> getCarByModel(@PathVariable String model) {
        List<Car> carList = carService.getCarByModel(model);
        return ResponseEntity.ok(carList);
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Car>> getCarByYear(@PathVariable String year) {
        List<Car> carList = carService.getCarByYear(year);
        return ResponseEntity.ok(carList);
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<List<Car>> getCarByPrice(@PathVariable String price) {
        List<Car> carList = carService.getCarByPrice(price);
        return ResponseEntity.ok(carList);
    }

    @GetMapping("/branchName/{branchName}")
    public ResponseEntity<List<Car>> getCarByBranche(@PathVariable String branchName) {
        List<Car> carList = carService.getByBranch(branchName);
        return ResponseEntity.ok(carList);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable Long id) {
        carService.deleteCarByid(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCarById(@PathVariable Long id, @RequestBody CarDto carDto) {
        carService.updateCarByid(id, carDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{carId}/branch/{branchId}")
    public Car addCarToBranch(@PathVariable Long carId, @PathVariable Long branchId) {
        Car car = carRepository.findById(carId).get();
        Branch branch = branchRepository.findById(branchId).get();

        car.setBranch(branch);
        return carRepository.save(car);
    }


}
