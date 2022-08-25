package com.example.carRental.entities;

import com.example.carRental.dtos.CarDto;
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "car_rental_id", referencedColumnName = "id")
    private CarRental carRental;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id")*/
    @JsonIgnore
    @OneToMany(mappedBy = "branch")
    private List<Employee> employeeList;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "branch_id")
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
