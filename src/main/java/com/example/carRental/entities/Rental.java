package com.example.carRental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "rentals")
@AllArgsConstructor
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime returnDate;
    private String opinion;
    private Double surcharge;
    @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;
}
