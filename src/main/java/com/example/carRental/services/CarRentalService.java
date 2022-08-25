package com.example.carRental.services;

import com.example.carRental.dtos.CarRentalDto;
import com.example.carRental.entities.CarRental;

import java.util.List;
import java.util.Optional;

public interface CarRentalService {
    CarRentalDto addCarRental(CarRentalDto carRentalDto);

    List<CarRentalDto> getCarRentals();

    CarRental findById(Long id);

    void deleteCarRental(Long id);

    void updateCarRentalById(Long id, CarRentalDto carRentalDto);

    CarRentalDto mapCarRentalToCarRentalDto(CarRental carRental);

    CarRentalDto mapCarRentalToCarRentalDtoForOptional(Optional<CarRental> carRental);

    CarRental mapperToCarRental(CarRentalDto carRentalDto);

    List<CarRentalDto> mapperToListCarRentalDto(List<CarRental> carRentalList);


}
