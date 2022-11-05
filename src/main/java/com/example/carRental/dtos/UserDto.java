
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
public class UserDto {
    private Long id;
    private String login;
    private String firstname;
    private String lastname;
    private String password;
    private Role role;
    private Address address;



}
