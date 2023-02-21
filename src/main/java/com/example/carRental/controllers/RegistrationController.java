package com.example.carRental.controllers;

import com.example.carRental.dtos.CompanyDto;
import com.example.carRental.dtos.EmployeeDto;
import com.example.carRental.dtos.PersonDto;
import com.example.carRental.dtos.UserDto;
import com.example.carRental.entities.Company;
import com.example.carRental.entities.Employee;
import com.example.carRental.entities.Person;
import com.example.carRental.repositories.EmployeeRepository;
import com.example.carRental.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public String register(@RequestBody UserDto userDto){
        return registrationService.register(userDto);

    }
    @PostMapping("/registerPerson")
    public Person registerPerson(@RequestBody @Valid PersonDto personDto){
        return registrationService.registerPerson(personDto);
    }

    @PostMapping("/registerEmployee")
    public Employee registerEmployee(@RequestBody EmployeeDto employeeDto){
        return registrationService.registerEmployee(employeeDto);
    }

    @PostMapping("/registerCompany")
    public Company registerCompany(@RequestBody CompanyDto companyDto){
        return registrationService.registerComapny(companyDto);
    }
}
