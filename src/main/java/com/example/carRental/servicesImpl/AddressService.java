package com.example.carRental.servicesImpl;

import com.example.carRental.dtos.AddressDto;
import com.example.carRental.entities.Address;
import com.example.carRental.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

}
