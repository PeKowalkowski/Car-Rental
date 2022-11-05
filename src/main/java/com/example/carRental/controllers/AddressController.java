package com.example.carRental.controllers;


import com.example.carRental.dtos.AddressDto;
import com.example.carRental.dtos.BranchDto;
import com.example.carRental.entities.Address;
import com.example.carRental.entities.Branch;
import com.example.carRental.services.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/addresses")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    ResponseEntity<List<AddressDto>> getAddresses(){
        List<AddressDto> addressDtoList = addressService.getAddresses();
        return ResponseEntity.ok(addressDtoList);
    }
    @GetMapping("/{id}")
    ResponseEntity<Optional<Address>> getById(@PathVariable Long id){
        Optional<Address> address = addressService.findById(id);
        return ResponseEntity.ok(address);
    }

}
