
package com.example.carRental.mappers;

import com.example.carRental.dtos.CarDto;
import com.example.carRental.entities.Car;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapperImpl implements Mapper<Car, CarDto> {

    private ModelMapper modelMapper;

    public CarMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CarDto mapperEntityToDto(Car car) {
        CarDto carDto = modelMapper.map(car,CarDto.class);
        return carDto;
    }

    @Override
    public Car mapperDtoToEntity(CarDto carDto) {
        return new Car(carDto.getBrand(), carDto.getModel(), carDto.getYear(),
                carDto.getColor(), carDto.getMileage(), carDto.getPrice(),carDto.getCarBodyType(),
                carDto.getStatus(),carDto.getBranch());
    }


}

