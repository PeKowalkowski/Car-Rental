package com.example.carRental.dtos;

import lombok.Data;

@Data
public class AddressDto {

    private Long id;
    private String city;
    private String zipCode;
    private String Country;
}
