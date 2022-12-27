package com.example.carRental.entities;

import com.example.carRental.dtos.ReservationDto;
import com.example.carRental.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Entity
@Data
@Table(name = "reservations")
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date reservationDate;


    @ManyToOne()
    private Car car;
    @OneToOne(cascade = CascadeType.ALL)
    private Rental rental;
    @OneToOne(cascade = CascadeType.ALL)
    private Return returnCar;
    @ManyToOne()
    private Company company;
    @ManyToOne()
    private Person person;
    private String name;

    public Reservation(Date reservationDate, Car car, Rental rental, Return returnCar, String name) {
        this.reservationDate = reservationDate;
        this.car = car;
        this.rental = rental;
        this.returnCar = returnCar;
        this.name = name;
    }

    public Reservation( String name,Car car) {
        this.car = car;
        this.name = name;
    }

    @PrePersist
    private void onCreate() {
        reservationDate = new Date();
    }
}
