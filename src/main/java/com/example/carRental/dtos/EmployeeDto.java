package com.example.carRental.dtos;

import com.example.carRental.entities.Authority;
import com.example.carRental.entities.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String login;
    private String firstname;
    private String lastname;
    private Authority authority;
    private String password;
    private Branch branch;



}
