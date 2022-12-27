package com.example.carRental.dtos;

import com.example.carRental.entities.BranchAddress;
import com.example.carRental.entities.Car;
import com.example.carRental.entities.CarRental;
import com.example.carRental.entities.Employee;
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
    private BranchAddress branchAddress;
    private CarRental carRental;
    private List<Employee> employeeDtoList;
    private List<Car> carDtoList;

    public BranchDto(Long id, String name, CarRental carRental) {
        this.id = id;
        this.name = name;
        this.carRental = carRental;
    }


    public BranchDto(Long id, String name, BranchAddress branchAddress, CarRental carRental) {
        this.id = id;
        this.name = name;
        this.branchAddress = branchAddress;
        this.carRental = carRental;
    }
}
