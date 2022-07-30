package com.example.carRental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car_rentals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String website;
    private String phoneNumber;
    private String owner;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "carRental_id")
    private List<Branch> branchList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "carRental_id")
    private List<Car> carList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "carRental_id")
    private List<Employee> employeeList;

}
