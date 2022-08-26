package com.example.carRental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String firstname;
    private String lastname;
    private String role;
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branch;

    public Employee(String login, String firstname, String lastname, String role, String password, Branch branch) {
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.password = password;
        this.branch = branch;
    }

    public Employee(Long id, String login, String firstname, String lastname, String role, String password) {
        this.id = id;
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.password = password;
    }
}
