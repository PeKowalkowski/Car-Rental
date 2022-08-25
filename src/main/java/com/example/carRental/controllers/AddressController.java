package com.example.carRental.controllers;


import com.example.carRental.dtos.AddressDto;
import com.example.carRental.entities.Address;
import com.example.carRental.servicesImpl.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/addresses")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

}
