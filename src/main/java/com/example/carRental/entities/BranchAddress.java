package com.example.carRental.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "branches_addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String city;
    @NotNull
    private String street;
    @NotNull
    private String zipCode;
    @NotNull
    private String Country;

}
