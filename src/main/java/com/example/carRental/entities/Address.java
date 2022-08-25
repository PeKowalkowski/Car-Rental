package com.example.carRental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String street;
    private String zipCode;
    private String Country;

    public Address(String city, String street, String zipCode, String country) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        Country = country;
    }

}
