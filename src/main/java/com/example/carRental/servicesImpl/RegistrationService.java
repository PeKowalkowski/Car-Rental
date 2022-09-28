package com.example.carRental.servicesImpl;

import com.example.carRental.dtos.EmployeeDto;
import com.example.carRental.entities.Employee;
import com.example.carRental.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Employee register(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setLogin(employeeDto.getLogin());
        employee.setFirstname(employeeDto.getFirstname());
        employee.setLastname(employeeDto.getLastname());
        employee.setPassword(bCryptPasswordEncoder.encode(employeeDto.getPassword()));
        employee.setAuthority(employeeDto.getAuthority());
        return employeeRepository.save(employee);
    }
}
