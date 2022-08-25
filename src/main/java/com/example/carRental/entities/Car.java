package com.example.carRental.entities;

import com.example.carRental.enums.CarBodyType;
import com.example.carRental.enums.Status;
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
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Branch branch;
    @Enumerated(EnumType.STRING)
    private CarBodyType carBodyType;
    @Enumerated(EnumType.STRING)
    private Status status;
}
