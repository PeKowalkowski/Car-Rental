package com.example.carRental.entities;

import com.example.carRental.dtos.CarDto;
import com.example.carRental.dtos.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "branches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "car_rental_id", referencedColumnName = "id")
    private CarRental carRental;

    @JsonIgnore
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Employee> employeeList;
    @JsonIgnore
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Car> carList;

    public Branch(String name) {
        this.name = name;
    }

    public Branch(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Branch(String name, List<CarDto> carDtoList) {
    this.name = name;
        this.carList =carList;
}


    public void setCarRental(CarRental carRental) {
        this.carRental = carRental;
    }
}
