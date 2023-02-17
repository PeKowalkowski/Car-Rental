package com.example.carRental.dtos;

import com.example.carRental.entities.Company;
import com.example.carRental.entities.Person;
import com.example.carRental.entities.Rental;
import com.example.carRental.entities.Return;
import com.example.carRental.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private Long id;
    private Date reservationDate;
    private Long carId;
    private Rental rental;
    private Return returnCar;
    private Person person;
    private Company company;
    private String name;
    private ReservationStatus reservationStatus;


    public ReservationDto(Long id, Date reservationDate, Long carId, Rental rental, Return returnCar) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.carId = carId;
        this.rental = rental;
        this.returnCar = returnCar;
    }



}
