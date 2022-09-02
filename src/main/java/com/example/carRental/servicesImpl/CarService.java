package com.example.carRental.servicesImpl;

import com.example.carRental.dtos.CarDto;
import com.example.carRental.entities.Car;
import com.example.carRental.repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    private static ModelMapper modelMapper;

    public CarDto addCar(CarDto carDto) {
        Car car = mapperToCar(carDto);
        Car carOut = carRepository.save(car);
        return mapperCarToCarDto(carOut);
    }

    private CarDto mapperCarToCarDto(Car car) {
        CarDto carDto = modelMapper.map(car,CarDto.class);
        return carDto;
    }

    private Car mapperToCar(CarDto carDto) {
        return new Car(carDto.getBrand(), carDto.getModel(), carDto.getYear(),
                carDto.getColor(), carDto.getMileage(), carDto.getPrice(),carDto.getCarBodyType(),
                carDto.getStatus(),carDto.getBranch());
    }

    public List<CarDto> getCars() {
        List<CarDto> carDtoList = carRepository.findAll().stream()
                .map(car -> {
                    CarDto carDto = new CarDto(car.getId(), car.getBrand(), car.getModel(), car.getYear(),
                            car.getColor(), car.getMileage(), car.getPrice(), car.getCarBodyType(),
                            car.getStatus(),car.getBranch());
                    return carDto;
                })
                .collect(Collectors.toList());
        return carDtoList;
    }

    public Optional<Car> getCarById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car;
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
