package com.example.carRental.services;

import com.example.carRental.dtos.ReservationDto;
import com.example.carRental.entities.Reservation;
import com.example.carRental.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {


    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationDto> getReservations() {
        List<ReservationDto> reservationDtoList = reservationRepository.findAll().stream()
                .map(reservation -> {
                    ReservationDto reservationDto = new ReservationDto(reservation.getId(), reservation.getReservationDate(),
                            reservation.getCar().getId(), reservation.getRental(),
                            reservation.getReturnCar(), reservation.getPerson(), reservation.getCompany(), reservation.getName(),
                            reservation.getReservationStatus());
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
