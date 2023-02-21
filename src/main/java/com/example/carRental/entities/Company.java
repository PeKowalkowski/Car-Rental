package com.example.carRental.entities;

import com.example.carRental.enums.Role;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "companies", uniqueConstraints = @UniqueConstraint(columnNames = "nip"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company extends User{

    @NotNull
    private String name;
    @NotNull
    private String nip;

    public Company(String login,String name, String nip, String firstname, String lastname, String password,
                   Address address,  Role role) {
        super(firstname, lastname, login, password, role, address);
        this.name = name;
        this.nip = nip;
    }

    public Company( Long id,String login, String name,String nip, String firstname, String lastname,
                    String password,Address address, Role role  ) {
        super(id, firstname, lastname, login, password, role, address);
        this.name = name;
        this.nip = nip;
    }
}
