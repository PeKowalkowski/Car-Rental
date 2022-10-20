package com.example.carRental.entities;

import com.example.carRental.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employees2", uniqueConstraints = @UniqueConstraint(columnNames = "login"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User{

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String firstname;
    private String lastname;*/

    /*@OneToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;*/

    /*@JsonIgnore
    private String password;*/
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branch;

    public Employee(Long id, String firstname, String lastname, String login, String password,  Branch branch, Role role) {
        super(id, firstname, lastname, login, password, role);
        this.branch = branch;
    }

    public Employee(String firstname, String lastname, String login, String password, Branch branch, Role role) {
        super(firstname, lastname, login, password, role);
        this.branch = branch;
    }

    public Employee(String firstname, String lastname, String login, String password, Role role) {
        super(firstname, lastname, login, password, role);
    }

    /* public Employee(String login, String firstname, String lastname, Authority authority, String password, Branch branch) {
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.authority = authority;
        this.password = password;
        this.branch = branch;
    }*/

    /*public Employee(Long id, String login, String firstname, String lastname, Authority authority, Branch branch) {
        this.id = id;
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.authority = authority;
        this.branch = branch;
    }*/


}
