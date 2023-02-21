package com.example.carRental.services;

import com.example.carRental.dtos.CarRentalDto;
import com.example.carRental.entities.CarRental;
import com.example.carRental.mappers.CarRentalMapperImpl;
import com.example.carRental.repositories.CarRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarRentalService {


    private CarRentalRepository carRentalRepository;


    private CarRentalMapperImpl carRentalMapper;

    public CarRentalService(CarRentalRepository carRentalRepository, CarRentalMapperImpl carRentalMapper) {
        this.carRentalRepository = carRentalRepository;
        this.carRentalMapper = carRentalMapper;
    }

    public CarRentalDto addCarRental(CarRentalDto carRentalDto) {
        CarRental carRental = carRentalMapper.mapperDtoToEntity(carRentalDto);
        CarRental carRentalOut = carRentalRepository.save(carRental);
        return carRentalMapper.mapperEntityToDto(carRentalOut);
    }


    public List<CarRentalDto> getCarRentals() {
        List<CarRentalDto> carRentalDtoList = carRentalRepository.findAll().stream()
                .map(carRental -> {
                    CarRentalDto carRentalDto = new CarRentalDto(carRental.getId(), carRental.getName(),
                            carRental.getWebsite(), carRental.getPhoneNumber(), carRental.getOwner(), carRental.getBranchList());
                    return carRentalDto;
                })
                .collect(Collectors.toList());
        return carRentalDtoList;
    }
    
    public Optional<CarRental> findById(Long id) {
        Optional<CarRental> carRental = carRentalRepository.findById(id);
        return carRental;
    }



    public void deleteCarRental(Long id) {
        carRentalRepository.deleteById(id);

    }


    public void updateCarRentalById(Long id, CarRentalDto carRentalDto) {
    CarRental carRental = new CarRental(id, carRentalDto.getName(), carRentalDto.getWebsite(),
            carRentalDto.getPhoneNumber(), carRentalDto.getOwner());
    carRentalRepository.save(carRental);
    }


}
