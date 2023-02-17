package com.example.carRental.controllers;

import com.example.carRental.dtos.ReservationDto;
import com.example.carRental.entities.Car;
import com.example.carRental.entities.Reservation;
import com.example.carRental.enums.ReservationStatus;
import com.example.carRental.enums.Status;
import com.example.carRental.repositories.CarRepository;
import com.example.carRental.repositories.CompanyRepository;
import com.example.carRental.repositories.PersonRepository;
import com.example.carRental.repositories.ReservationRepository;
import com.example.carRental.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {


    private ReservationService reservationService;

    private CarRepository carRepository;

    private PersonRepository personRepository;

    private ReservationRepository reservationRepository;

    private CompanyRepository companyRepository;

    public ReservationController(ReservationService reservationService, CarRepository carRepository, PersonRepository personRepository,
                                 ReservationRepository reservationRepository, CompanyRepository companyRepository) {
        this.reservationService = reservationService;
        this.carRepository = carRepository;
        this.personRepository = personRepository;
        this.reservationRepository = reservationRepository;
        this.companyRepository = companyRepository;
    }

    @PostMapping("/{carId}/{personId}/personReservations")
    public ResponseEntity<Reservation> addPersonReservation(@PathVariable(value = "carId") Long carId,
                                                            @PathVariable(value = "personId") Long personId,
                                                            @RequestBody Reservation reservationRequest) {

        Car car = carRepository.findById(carId).get();
        Status carStatus = Status.AVAILABLE;
        if (car.getStatus() == carStatus) {
            Reservation reservation = personRepository.findById(personId).map(person -> {
                reservationRequest.setPerson(person);
                reservationRequest.setCar(car);
                reservationRequest.setName("Reservation user with PESEL : " + person.getPesel());
                car.setStatus(Status.NOAVAILABLE);

                return reservationRepository.save(reservationRequest);
            }).orElseThrow(() -> new RuntimeException("Not found"));
            return new ResponseEntity<>(reservation, HttpStatus.CREATED);
        } else {
            return null;
        }

    }

    @PostMapping("/{carId}/{comapnyId}/companyReservations")
    public ResponseEntity<Reservation> addCompanyReservation(@PathVariable(value = "carId") Long carId,
                                                             @PathVariable(value = "comapnyId") Long comapnyId,
                                                             @RequestBody Reservation reservationRequest) {
        Car car = carRepository.findById(carId).get();
        Status carStatus = Status.AVAILABLE;
        if (car.getStatus() == carStatus) {
            Reservation reservation = companyRepository.findById(comapnyId).map(company -> {
                reservationRequest.setCompany(company);
                reservationRequest.setCar(car);
                reservationRequest.setName("Reservation user with NIP : " + company.getNip());
                car.setStatus(Status.NOAVAILABLE);

                return reservationRepository.save(reservationRequest);
            }).orElseThrow(() -> new RuntimeException("Not found"));
            return new ResponseEntity<>(reservation, HttpStatus.CREATED);
        } else {
            return null;
        }

    }
    @GetMapping
    public ResponseEntity<List<ReservationDto>> getReservations() {
        List<ReservationDto> reservationDtoList = reservationService.getReservations();
        return ResponseEntity.ok(reservationDtoList);
    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<Reservation>> getById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.findById(id);
        return ResponseEntity.ok(reservation);
    }

    @PutMapping("/{reservationId}/{carId}")
    ResponseEntity<Reservation> closeReservation(@PathVariable(value = "carId") Long carId,
                                          @PathVariable(value = "reservationId") Long reservationId){
        Car car = carRepository.findById(carId).get();
        car.setStatus(Status.AVAILABLE);
        Reservation reservation1 = reservationRepository.findById(reservationId).get();
        reservation1.setReservationStatus(ReservationStatus.NOACTIVE);
        reservationRepository.save(reservation1);
        return ResponseEntity.ok(reservation1);
    }


}
