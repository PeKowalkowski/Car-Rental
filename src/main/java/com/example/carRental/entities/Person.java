
package com.example.carRental.entities;

import com.example.carRental.enums.Role;
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
@DiscriminatorValue("persons")
public class Person extends User{

/*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private String password;
    private String pesel;
    @OneToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;*/

    private String pesel;




    public Person(String firstname, String lastname, String login, String password, String pesel, Role role) {
        super(firstname, lastname, login, password, role);
        this.pesel = pesel;
    }

    public Person(Long id, String firstname, String lastname, String login, String password, String pesel, Role role) {
        super(id, firstname, lastname, login, password, role);
        this.pesel = pesel;
    }


}

