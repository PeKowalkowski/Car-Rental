package com.example.carRental.controllers;

import com.example.carRental.dtos.EmployeeDto;
import com.example.carRental.entities.Employee;
import com.example.carRental.repositories.EmployeeRepository;
import com.example.carRental.servicesImpl.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RegistrationService registrationService;


    @PostMapping
    public Employee register(@RequestBody EmployeeDto employeeDto){
       Employee employee = registrationService.register(employeeDto);
       return employee;

    }

}
