package com.example.carRental.dtos;

import com.example.carRental.entities.Branch;
import com.example.carRental.enums.CarBodyType;
import com.example.carRental.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private Long id;
    private String brand;
    private String model;
    private String year;
    private String color;
    private String mileage;
    private Long price;
    @Enumerated(EnumType.STRING)
    private CarBodyType carBodyType;
    @Enumerated(EnumType.STRING)
    private Status status = Status.AVAILABLE;
    private Branch branch;
}
