package com.example.carRental.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employees", uniqueConstraints = @UniqueConstraint(columnNames = "login"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee /*implements UserDetails*/ {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String firstname;
    private String lastname;

    @OneToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;

    @JsonIgnore
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branch;

    public Employee(String login, String firstname, String lastname, Authority authority, String password, Branch branch) {
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.authority = authority;
        this.password = password;
        this.branch = branch;
    }

    public Employee(Long id, String login, String firstname, String lastname, Authority authority, Branch branch) {
        this.id = id;
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.authority = authority;
        this.branch = branch;
    }
}
