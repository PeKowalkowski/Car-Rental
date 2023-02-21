package com.example.carRental.entities;

import com.example.carRental.enums.ReservationStatus;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "reservations")
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date reservationDate;
    @NotNull
    @ManyToOne()
    private Car car;
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Rental rental;
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Return returnCar;
    @ManyToOne()
    private Company company;
    @ManyToOne()
    private Person person;
    private String name;
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus = ReservationStatus.ACTIVE;


    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @PrePersist
    private void onCreate() {
        reservationDate = new Date();
    }
}
