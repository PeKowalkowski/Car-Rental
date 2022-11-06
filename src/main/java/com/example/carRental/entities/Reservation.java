package com.example.carRental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "reservations")
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime reservationDate;
    private Double price;

    @OneToOne(cascade = CascadeType.ALL)
    private Rental rental;
    @OneToOne(cascade = CascadeType.ALL)
    private Return returnCar;
    @ManyToOne
    private Company company;
    @ManyToOne
    private Person person;



}
