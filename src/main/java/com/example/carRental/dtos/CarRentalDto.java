package com.example.carRental.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRentalDto {
    private Long id;
    private String name;
    private String website;
    private String phoneNumber;
    private String owner;

}
