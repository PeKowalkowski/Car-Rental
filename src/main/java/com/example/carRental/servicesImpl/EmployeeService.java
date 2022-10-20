package com.example.carRental.servicesImpl;

import com.example.carRental.dtos.EmployeeDto;
import com.example.carRental.entities.Employee;
import com.example.carRental.enums.Role;
import com.example.carRental.repositories.EmployeeRepository;
/*
import com.example.carRental.services.UserService;
*/
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService /*implements UserService<Employee, EmployeeDto> */{


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static ModelMapper modelMapper;

    /*public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = mapperToEmployee(employeeDto);
        Employee employeeOut = employeeRepository.save(employee);
        return mapEmployeeToEmployeeDto(employeeOut);
    }*/

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
                            employee.getLastname(), employee.getPassword(), employee.getBranch(), employee.getRole());
                    return employeeDto;
                })
                .collect(Collectors.toList());
        return employeeDtoListList;
    }

    /*private EmployeeDto mapEmployeeToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }

    private Employee mapperToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getLogin(), employeeDto.getFirstname(), employeeDto.getLastname(),
                 employeeDto.getPassword(), employeeDto.getBranch(),employeeDto.getRole(Role.EMPLOYEE));
        return employee;
    }*/


    public Optional<Employee> getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional;
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = new Employee(id, employeeDto.getLogin(), employeeDto.getFirstname(), employeeDto.getLastname(),
               employeeDto.getPassword(), employeeDto.getBranch(), Role.valueOf(String.valueOf(employeeDto.getRole())));
        employeeRepository.save(employee);
    }


    /*@Override
    public EmployeeDto addUser(EmployeeDto employeeDto) {
        Employee employee = mapperToUser(employeeDto);
        Employee employeeOut = employeeRepository.save(employee);
        return mapUserToUserDTO(employeeOut);
    }

    @Override
    public List<Employee> getUsers() {
        return null;
    }

    @Override
    public Optional<Employee> getUserByid(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public void updateUserById(Long id, EmployeeDto employeeDto) {

    }

    @Override
    public EmployeeDto mapUserToUserDTO(Employee employee) {
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }

    @Override
    public Employee mapperToUser(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getLogin(), employeeDto.getFirstname(), employeeDto.getLastname(),
                employeeDto.getAuthority(), employeeDto.getPassword(), employeeDto.getBranch());
        return employee;
    }*/
}
