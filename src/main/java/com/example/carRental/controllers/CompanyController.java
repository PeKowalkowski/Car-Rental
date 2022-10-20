package com.example.carRental.controllers;

import com.example.carRental.dtos.CompanyDto;
import com.example.carRental.dtos.PersonDto;
import com.example.carRental.entities.Company;
import com.example.carRental.entities.Person;
import com.example.carRental.servicesImpl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @GetMapping
    public ResponseEntity<List<CompanyDto>> getCompanies(){
        List<CompanyDto> companyDtoList = companyService.getCompanies();
        return  ResponseEntity.ok(companyDtoList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Company>> getCompanyById(@PathVariable Long id){
        Optional<Company> companyOptional = companyService.getCompanyById(id);
        return ResponseEntity.ok(companyOptional);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable Long id){
        companyService.deleteCompanyById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCompany(@PathVariable Long id, @RequestBody CompanyDto companyDto){
        companyService.updatCompany(id, companyDto);
        return ResponseEntity.noContent().build();
    }
}
