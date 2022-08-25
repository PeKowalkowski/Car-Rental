package com.example.carRental.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car_rentals")
@Data
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String website;
    private String phoneNumber;
    private String owner;

    @JsonIgnore
    @OneToMany(mappedBy = "carRental", cascade = CascadeType.REMOVE)
    private List<Branch> branchList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "carRental_id")
    private List<Car> carList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "carRental_id")
    private List<Employee> employeeList;

    public CarRental() {
    }

    public CarRental(Long id, String name, String website, String phoneNumber, String owner) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }


    public CarRental(String name, String website, String phoneNumber, String owner) {
        this.name = name;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    public CarRental(String name, String website, String phoneNumber, String owner,
                     List<Branch> branchList, List<Car> carList, List<Employee> employeeList) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
        this.branchList = branchList;
        this.carList = carList;
        this.employeeList = employeeList;
    }

    public CarRental(String name, String website, String phoneNumber, String owner, List<Branch> branchList) {
        this.name = name;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
        this.branchList = branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    public CarRental(Long id, String name, String website, String phoneNumber, String owner, List<Branch> branchList) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
        this.branchList = branchList;
    }
}
