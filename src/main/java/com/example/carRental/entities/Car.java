package com.example.carRental.entities;

import com.example.carRental.enums.CarBodyType;
import com.example.carRental.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branch;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="car_id")
    private List<Reservation> reservationList;

    public Car(String brand, String model, String year,
               String color, String mileage, Long price, CarBodyType carBodyType, Status status, Branch branch) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.carBodyType = carBodyType;
        this.status = status;
        this.branch = branch;
    }

    public Car(Long id, String brand, String model, String year, String color, String mileage, Long price, CarBodyType carBodyType, Status status, Branch branch) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.carBodyType = carBodyType;
        this.status = status;
        this.branch = branch;
    }



}
