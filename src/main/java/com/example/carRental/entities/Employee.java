package com.example.carRental.entities;

import com.example.carRental.enums.Role;
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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branch;

    public Employee(String firstname, String lastname, String login, String password, Address address, Role role) {
        super(firstname, lastname, login, password, role, address);

    }


    public Employee(Long id, String firstname, String lastname, String login,
                    String password, Branch branch, Address address, Role role) {
        super(id, firstname, lastname, login, password, role, address);
        this.branch = branch;
    }
}
