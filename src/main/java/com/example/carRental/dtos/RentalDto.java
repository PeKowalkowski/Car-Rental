package com.example.carRental.dtos;

import com.example.carRental.entities.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDto {

    private Long id;
    private LocalDateTime returnDate;
    private String opinion;
    private Double surcharge;
    private Reservation reservation;
}
