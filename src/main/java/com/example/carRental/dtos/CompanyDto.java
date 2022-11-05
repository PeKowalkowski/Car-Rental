package com.example.carRental.dtos;

import com.example.carRental.entities.Address;
import com.example.carRental.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {


    private Long id;
    private String login;
    private String name;
    private String nip;
    private String firstname;
    private String lastname;
    private String password;
    private Address address;
    private Role role;
}
