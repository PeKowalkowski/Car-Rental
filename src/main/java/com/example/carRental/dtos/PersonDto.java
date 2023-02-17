
package com.example.carRental.dtos;

/*
import com.example.carRental.entities.Authority;
*/

import com.example.carRental.entities.Address;
import com.example.carRental.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto  {


    private Long id;
    private String login;
    private String firstname;
    private String lastname;
    private String password;
    private String pesel;
    private Address address;
    private Role role;


    public PersonDto(Long id, String login, String firstname, String lastname, String pesel, Address address, Role role) {
        this.id = id;
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pesel = pesel;
        this.address = address;
        this.role = role;
    }
}

