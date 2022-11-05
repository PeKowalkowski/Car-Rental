package com.example.carRental.services;

import com.example.carRental.dtos.AddressDto;
import com.example.carRental.entities.Address;
import com.example.carRental.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<AddressDto> getAddresses() {
        List<AddressDto> addressDtoList = addressRepository.findAll()
                .stream().map(address -> {
                    AddressDto addressDto = new AddressDto(address.getId(), address.getStreet(), address.getCity(),
                            address.getZipCode(), address.getCountry());
                    return addressDto;
                })
                .collect(Collectors.toList());
        return addressDtoList;
    }

    public Optional<Address> findById(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        return addressOptional;
    }
}
