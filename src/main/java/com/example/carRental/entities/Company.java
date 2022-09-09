package com.example.carRental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Tables;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "comanies", uniqueConstraints = @UniqueConstraint(columnNames = "nip"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company extends Customer{

    private String name;
    private String nip;

}
