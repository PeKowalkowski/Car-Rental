package com.example.carRental.servicesImpl;

import com.example.carRental.dtos.CarRentalDto;
import com.example.carRental.entities.CarRental;
import com.example.carRental.repositories.CarRentalRepository;
import com.example.carRental.services.CarRentalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarRentalServiceImpl implements CarRentalService {

    @Autowired
    private CarRentalRepository carRentalRepository;


    private static ModelMapper modelMapper;

    public CarRentalServiceImpl(CarRentalRepository carRentalRepository) {
        this.carRentalRepository = carRentalRepository;
    }

    @Override
    public CarRentalDto addCarRental(CarRentalDto carRentalDto) {
        CarRental carRental = mapperToCarRental(carRentalDto);
        CarRental carRentalOut = carRentalRepository.save(carRental);
        return mapCarRentalToCarRentalDto(carRentalOut);
    }

    @Override
    public List<CarRentalDto> getCarRentals() {
        List<CarRentalDto> carRentalDtoList = carRentalRepository.findAll().stream()
                .map(carRental -> {
                    CarRentalDto carRentalDto = new CarRentalDto(carRental.getId(), carRental.getName(),
                            carRental.getWebsite(), carRental.getPhoneNumber(), carRental.getOwner());
                    return carRentalDto;
                })
                .collect(Collectors.toList());
        return carRentalDtoList;
    }

    public Optional<CarRental> findById(Long id) {
        Optional<CarRental> carRental = carRentalRepository.findById(id);
        return carRental;
    }

    @Override
    public void deleteCarRental(Long id) {
        carRentalRepository.deleteById(id);
    }


   @Override
    public void updateCarRentalById(Long id, CarRentalDto carRentalDto) {
    CarRental carRental = new CarRental(id, carRentalDto.getName(), carRentalDto.getWebsite(),
            carRentalDto.getPhoneNumber(), carRentalDto.getOwner());
    carRentalRepository.save(carRental);
    }



    @Override
    public CarRentalDto mapCarRentalToCarRentalDtoForOptional(Optional<CarRental> carRental) {
        CarRentalDto carRentalDto = modelMapper.map(carRental, CarRentalDto.class);
        return carRentalDto;
    }

    @Override
    public CarRentalDto mapCarRentalToCarRentalDto(CarRental carRental) {
        CarRentalDto carRentalDto = modelMapper.map(carRental, CarRentalDto.class);
        return carRentalDto;
    }

    @Override
    public CarRental mapperToCarRental(CarRentalDto carRentalDto) {
        return new CarRental(carRentalDto.getName(), carRentalDto.getWebsite(), carRentalDto.getPhoneNumber(),
                carRentalDto.getOwner());
    }

    @Override
    public List<CarRentalDto> mapperToListCarRentalDto(List<CarRental> carRentalList) {
        return carRentalList.stream()
                .map(carRental -> mapCarRentalToCarRentalDto(carRental))
                .collect(Collectors.toList());
    }


}
