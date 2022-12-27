package com.example.carRental.services;

import com.example.carRental.dtos.CarDto;
import com.example.carRental.dtos.PersonDto;
import com.example.carRental.dtos.ReservationDto;
import com.example.carRental.entities.Branch;
import com.example.carRental.entities.Car;
import com.example.carRental.entities.Person;
import com.example.carRental.entities.Reservation;
import com.example.carRental.enums.Status;
import com.example.carRental.mappers.CarMapperImpl;
/*
import com.example.carRental.mappers.ReservationMapperImpl;
*/
import com.example.carRental.repositories.CarRepository;
import com.example.carRental.repositories.CompanyRepository;
import com.example.carRental.repositories.PersonRepository;
import com.example.carRental.repositories.ReservationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    /*
        @Autowired
        private ReservationMapperImpl reservationMapper;*/
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarMapperImpl carMapper;


    public List<ReservationDto> getReservations() {
        List<ReservationDto> reservationDtoList = reservationRepository.findAll().stream()
                .map(reservation -> {
                    ReservationDto reservationDto = new ReservationDto(reservation.getId(), reservation.getReservationDate(),
                            reservation.getCar().getId(), reservation.getRental(),
                            reservation.getReturnCar(), reservation.getPerson(), reservation.getCompany(), reservation.getName());
                    return reservationDto;
                })
                .collect(Collectors.toList());
        return reservationDtoList;
    }

    public Optional<Reservation> findById(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation;
    }

}
