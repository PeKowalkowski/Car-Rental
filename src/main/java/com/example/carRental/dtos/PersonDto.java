
package com.example.carRental.dtos;

import com.example.carRental.entities.Authority;
import com.example.carRental.entities.Branch;
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
    private Role role;



/*private Authority authority;*/



}

