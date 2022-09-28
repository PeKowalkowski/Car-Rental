package com.example.carRental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "persons", uniqueConstraints = @UniqueConstraint(columnNames = "pesel"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person extends Customer{

    private String firstName;
    private String lastName;
    private String pesel;

}
