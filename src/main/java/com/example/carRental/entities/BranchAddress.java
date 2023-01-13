package com.example.carRental.entities;

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
    private String city;
    private String street;
    private String zipCode;
    private String Country;
    /*@OneToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branch;*/
}
