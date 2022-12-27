package com.example.carRental.dtos;

import com.example.carRental.entities.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnDto {

    private Long id;
    private LocalDateTime rentalDate;
    private String comments;
    private Reservation reservation;

}
