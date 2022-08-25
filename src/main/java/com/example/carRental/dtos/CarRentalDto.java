package com.example.carRental.dtos;

import com.example.carRental.entities.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRentalDto {
    private Long id;
    private String name;
    private String website;
    private String phoneNumber;
    private String owner;
    private List<Branch> branchList;

}
