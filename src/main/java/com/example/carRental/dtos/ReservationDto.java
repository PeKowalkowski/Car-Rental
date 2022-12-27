package com.example.carRental.dtos;

import com.example.carRental.entities.*;
import com.example.carRental.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
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


    /*private Long personId;*/
   /* private Long companyId;*/
    private String name;





    public ReservationDto(Long id, Date reservationDate, Rental rental, Return returnCar) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.rental = rental;
        this.returnCar = returnCar;
    }

    public ReservationDto(Long id, Date reservationDate, Long carId, Rental rental, Return returnCar) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.carId = carId;
        this.rental = rental;
        this.returnCar = returnCar;
    }



}
