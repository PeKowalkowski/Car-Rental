package com.example.carRental.services;

import com.example.carRental.dtos.CompanyDto;
import com.example.carRental.entities.Company;
import com.example.carRental.enums.Role;
import com.example.carRental.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Company signUpCompany(Company company){
        boolean companyExist = companyRepository.findByLogin(company.getLogin()).isPresent();
        if(companyExist){
            throw new IllegalStateException("Zajety");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(company.getPassword());
        company.setPassword(encodedPassword);
        companyRepository.save(company);
        return company;


    }
    public List<CompanyDto> getCompanies() {
        List<CompanyDto> companyDtoList = companyRepository.findAll().stream()
                .map(company -> {
                    CompanyDto companyDto = new CompanyDto(company.getId(), company.getLogin(), company.getName(),
                            company.getNip(),company.getFirstname(), company.getLastname(), company.getPassword(),
                            company.getAddress(), company.getRole());
                    return companyDto;
                })
                .collect(Collectors.toList());
        return companyDtoList;
    }

    public Optional<Company> getCompanyById(Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        return companyOptional;
    }

    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }

    public void updatCompany(Long id, CompanyDto companyDto) {
        Company company = new Company(id, companyDto.getLogin(), companyDto.getName(),  companyDto.getNip(),
                companyDto.getFirstname(), companyDto.getLastname(), companyDto.getPassword(),companyDto.getAddress(),
                Role.valueOf(String.valueOf(companyDto.getRole())));
        companyRepository.save(company);
    }

    public List<Company> findByAddressId(Long id){
        return companyRepository.findByAddress_Id(id);
    }
}
