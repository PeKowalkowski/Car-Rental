package com.example.carRental.services;

import com.example.carRental.dtos.CompanyDto;
import com.example.carRental.dtos.EmployeeDto;
import com.example.carRental.dtos.PersonDto;
import com.example.carRental.dtos.UserDto;
import com.example.carRental.entities.Company;
import com.example.carRental.entities.Employee;
import com.example.carRental.entities.Person;
import com.example.carRental.entities.User;
import com.example.carRental.enums.Role;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    private UserService userService;

    private PersonService personService;

    private EmployeeService employeeService;

    private CompanyService companyService;

    public RegistrationService(UserService userService, PersonService personService,
                               EmployeeService employeeService, CompanyService companyService) {
        this.userService = userService;
        this.personService = personService;
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    public String register(UserDto userDto){

        String user = userService.signUpUser(
                new User(
                        userDto.getFirstname(),
                        userDto.getLastname(),
                        userDto.getLogin(),
                        userDto.getPassword(),
                        Role.USER
                )
        );
        return user;
    }

    public Person registerPerson(PersonDto personDto) {

        Person person = personService.signUpPerson(
                new Person(
                        personDto.getFirstname(),
                        personDto.getLastname(),
                        personDto.getLogin(),
                        personDto.getPassword(),
                        personDto.getPesel(),
                        personDto.getAddress(),
                        Role.USER
                )
        );
        return person;
    }

    public Employee registerEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeService.signUpEmployee(
            new Employee(
                    employeeDto.getFirstname(),
                    employeeDto.getLastname(),
                    employeeDto.getLogin(),
                    employeeDto.getPassword(),
                    employeeDto.getAddress(),
                    Role.USER
            )
        );
        return employee;
    }

    public Company registerComapny(CompanyDto companyDto) {

        Company company = companyService.signUpCompany(
                new Company(
                        companyDto.getLogin(),
                        companyDto.getName(),
                        companyDto.getNip(),
                        companyDto.getFirstname(),
                        companyDto.getLastname(),
                        companyDto.getPassword(),
                        companyDto.getAddress(),
                        Role.USER
                )
        );
        return company;
    }
}
