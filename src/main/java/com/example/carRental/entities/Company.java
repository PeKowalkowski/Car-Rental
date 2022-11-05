package com.example.carRental.entities;

import com.example.carRental.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Tables;

import javax.persistence.*;

@Entity
@Table(name = "companies", uniqueConstraints = @UniqueConstraint(columnNames = "nip"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company extends User{

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;*/
    private String name;
    private String nip;


    public Company(Long id,String login,String name, String nip, String firstname, String lastname,  String password, Role role ) {
        super(id, firstname, lastname, login, password, role);
        this.name = name;
        this.nip = nip;
    }

    public Company(String login, String name, String nip, String firstname, String lastname,  String password, Role role ) {
        super(firstname, lastname, login, password, role);
        this.name = name;
        this.nip = nip;
    }


    public Company(String login,String name, String nip, String firstname, String lastname, String password,
                   Address address,  Role role) {
        super(firstname, lastname, login, password, role, address);
        this.name = name;
        this.nip = nip;
    }

    public Company( Long id,String login, String name,String nip, String firstname, String lastname, String password,Address address, Role role  ) {
        super(id, firstname, lastname, login, password, role, address);
        this.name = name;
        this.nip = nip;
    }
}
