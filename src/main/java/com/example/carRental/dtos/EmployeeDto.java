package com.example.carRental.dtos;

import com.example.carRental.entities.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String login;
    private String firstname;
    private String lastname;
    private String role;
    private String password;
    private Branch branch;
}
