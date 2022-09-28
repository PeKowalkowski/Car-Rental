package com.example.carRental.servicesImpl;

import com.example.carRental.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

}
