package com.example.carRental.dtos;

import com.example.carRental.entities.CarRental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDto {

    private Long id;
    private String name;
    private CarRental carRental;
    private List<EmployeeDto> employeeDtoList;
    private List<CarDto> carDtoList;

    public BranchDto(Long id, String name, CarRental carRental) {
        this.id = id;
        this.name = name;
        this.carRental = carRental;
    }


}