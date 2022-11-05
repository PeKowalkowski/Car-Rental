package com.example.carRental.services;

import com.example.carRental.dtos.EmployeeDto;
import com.example.carRental.entities.Employee;
import com.example.carRental.enums.Role;
import com.example.carRental.repositories.EmployeeRepository;
/*
import com.example.carRental.services.UserService;
*/
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService{


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public Employee signUpEmployee(Employee employee){
        boolean employeeExist = employeeRepository.findByLogin(employee.getLogin()).isPresent();
        if(employeeExist){
            throw new IllegalStateException("Zajęty");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);
        employeeRepository.save(employee);
        return employee;

    }

    public List<EmployeeDto> getEmployees() {
        List<EmployeeDto> employeeDtoListList = employeeRepository.findAll().stream()
                .map(employee -> {
                    EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getLogin(), employee.getFirstname(),
                            employee.getLastname(), employee.getPassword(), employee.getBranch(),employee.getAddress(),
                            employee.getRole());
                    return employeeDto;
                })
                .collect(Collectors.toList());
        return employeeDtoListList;
    }

    public Optional<Employee> getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional;
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = new Employee(id,employeeDto.getFirstname(),employeeDto.getLastname(), employeeDto.getLogin(),
               employeeDto.getPassword(), employeeDto.getBranch(),employeeDto.getAddress(),
                Role.valueOf(String.valueOf(employeeDto.getRole())));
        employeeRepository.save(employee);
    }
}
