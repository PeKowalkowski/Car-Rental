
package com.example.carRental.entities;

import com.example.carRental.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons", uniqueConstraints = @UniqueConstraint(columnNames = "pesel"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person extends User{

    private String pesel;



    public Person(Long id, String firstname, String lastname, String login, String password, String pesel, Role role) {
        super(id, firstname, lastname, login, password, role);
        this.pesel = pesel;
    }


    public Person(String firstname, String lastname, String login, String password, String pesel, Address address, Role role) {
        super(firstname, lastname, login, password, role, address);
        this.pesel = pesel;
    }


}

