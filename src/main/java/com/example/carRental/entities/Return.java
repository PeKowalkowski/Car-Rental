package com.example.carRental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "returns")
@AllArgsConstructor
@NoArgsConstructor
public class Return {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime rentalDate;
    private String comments;
    @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;
}
