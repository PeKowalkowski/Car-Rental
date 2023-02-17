package com.example.carRental.mappers;

import com.example.carRental.entities.Car;
import com.example.carRental.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper <E,D>{


    public D mapperEntityToDto(E e);

    public E mapperDtoToEntity(D d);

}
