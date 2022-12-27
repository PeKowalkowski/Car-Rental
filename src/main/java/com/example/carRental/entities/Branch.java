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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "branch")
    private BranchAddress branchAddress;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "car_rental_id", referencedColumnName = "id")
    private CarRental carRental;

    @JsonIgnore
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Employee> employeeList;
    @JsonIgnore
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Car> carList;

    public Branch(Long id, String name, BranchAddress branchAddress) {
        this.id = id;
        this.name = name;
        this.branchAddress = branchAddress;
    }

    public Branch(String name, BranchAddress branchAddress) {
        this.name = name;
        this.branchAddress = branchAddress;
    }

    public void setCarRental(CarRental carRental) {
        this.carRental = carRental;
    }
}
