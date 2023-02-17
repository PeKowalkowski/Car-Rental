package com.example.carRental.services;

import com.example.carRental.dtos.CarDto;
import com.example.carRental.entities.Branch;
import com.example.carRental.entities.Car;
/*import com.example.carRental.mappers.CarMapper;*/
import com.example.carRental.enums.Status;
import com.example.carRental.mappers.CarMapperImpl;
import com.example.carRental.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {


    private CarRepository carRepository;


    private CarMapperImpl carMapper;

    public CarService(CarRepository carRepository, CarMapperImpl carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public CarDto addCar(CarDto carDto) {
        Car car = carMapper.mapperDtoToEntity(carDto);
        Car carOut = carRepository.save(car);
        return carMapper.mapperEntityToDto(carOut);
    }

    public List<CarDto> getCars() {
        List<CarDto> carDtoList = carRepository.findAll().stream()
                .map(car -> {
                    CarDto carDto = new CarDto(car.getId(), car.getBrand(), car.getModel(), car.getYear(),
                            car.getColor(), car.getMileage(), car.getPrice(), car.getCarBodyType(),
                            car.getStatus(), car.getBranch());
                    return carDto;
                })
                .collect(Collectors.toList());
        return carDtoList;
    }

    public Optional<Car> getCarById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car;
    }

    public List<Car> getCarByBrand(String brand) {
        List<Car> carList = carRepository.getCarByBrand(brand).stream()
                .map(car -> {
                    Car car2 = new Car(car.getId(), car.getBrand(), car.getModel(), car.getYear(),
                            car.getColor(), car.getMileage(), car.getPrice(), car.getCarBodyType(),
                            car.getStatus(), car.getBranch());
                    return car2;
                })
                .collect(Collectors.toList());
        return carList;
    }

    public List<Car> getCarByModel(String model) {
        List<Car> carList = carRepository.getCarByModel(model).stream()
                .map(car -> {
                    Car car2 = new Car(car.getId(), car.getBrand(), car.getModel(), car.getYear(),
                            car.getColor(), car.getMileage(), car.getPrice(), car.getCarBodyType(),
                            car.getStatus(), car.getBranch());
                    return car2;
                })
                .collect(Collectors.toList());
        return carList;
    }

    public List<Car> getCarByYear(String year) {
        List<Car> carList = carRepository.getCarByYear(year).stream()
                .map(car -> {
                    Car car2 = new Car(car.getId(), car.getBrand(), car.getModel(), car.getYear(),
                            car.getColor(), car.getMileage(), car.getPrice(), car.getCarBodyType(),
                            car.getStatus(), car.getBranch());
                    return car2;
                })
                .collect(Collectors.toList());
        return carList;
    }

    public List<Car> getCarByPrice(String price) {
        List<Car> carList = carRepository.getCarByPrice(price).stream()
                .map(car -> {
                    Car car2 = new Car(car.getId(), car.getBrand(), car.getModel(), car.getYear(),
                            car.getColor(), car.getMileage(), car.getPrice(), car.getCarBodyType(),
                            car.getStatus(), car.getBranch());
                    return car2;
                })
                .collect(Collectors.toList());
        return carList;
    }

    public List<Car> getByBranch(String branchName) {
        List<Car> carList = carRepository.getByBranch(branchName).stream()
                .map(car -> {
                    Car car2 = new Car(car.getId(), car.getBrand(), car.getModel(), car.getYear(),
                            car.getColor(), car.getMileage(), car.getPrice(), car.getCarBodyType(),
                            car.getStatus(), car.getBranch());
                    return car2;
                })
                .collect(Collectors.toList());
        return carList;
    }


    public void deleteCarByid(Long id) {
        carRepository.deleteById(id);
    }

    public void updateCarByid(Long id, CarDto carDto) {
        Car car = new Car(id, carDto.getBrand(), carDto.getModel(), carDto.getYear(), carDto.getColor(), carDto.getMileage(),
                carDto.getPrice(), carDto.getCarBodyType(), carDto.getStatus(), carDto.getBranch());
        carRepository.save(car);
    }


}
