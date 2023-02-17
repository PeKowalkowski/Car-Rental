package com.example.carRental.mappers;

import com.example.carRental.dtos.CarRentalDto;
import com.example.carRental.entities.CarRental;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CarRentalMapperImpl implements Mapper<CarRental, CarRentalDto> {


    private ModelMapper modelMapper;

    public CarRentalMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CarRentalDto mapperEntityToDto(CarRental carRental) {
        CarRentalDto carRentalDto = modelMapper.map(carRental, CarRentalDto.class);
        return carRentalDto;
    }

    @Override
    public CarRental mapperDtoToEntity(CarRentalDto carRentalDto) {
        return new CarRental(carRentalDto.getName(), carRentalDto.getWebsite(), carRentalDto.getPhoneNumber(),
                carRentalDto.getOwner(), carRentalDto.getBranchList());
    }


}
