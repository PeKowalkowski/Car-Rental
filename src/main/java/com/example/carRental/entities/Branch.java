package com.example.carRental.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "branches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
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
