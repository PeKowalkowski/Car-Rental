/*
package com.example.carRental.mappers;

import com.example.carRental.dtos.ReservationDto;
import com.example.carRental.entities.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapperImpl implements Mapper<Reservation, ReservationDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ReservationDto mapperEntityToDto(Reservation reservation) {
        ReservationDto reservationDto = modelMapper.map(reservation,ReservationDto.class);
        return reservationDto;
    }

    @Override
    public Reservation mapperDtoToEntity(ReservationDto reservationDto) {
        return new Reservation(reservationDto.getReservationDate(), reservationDto.getCar(),*/
/* reservationDto.getCarStatus(),
                reservationDto.getPrice(),*//*
reservationDto.getRental(),reservationDto.getReturnCar(),reservationDto.getPerson());
    }
}
*/
