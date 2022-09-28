package com.example.carRental.servicesImpl;

import com.example.carRental.dtos.EmployeeDto;
import com.example.carRental.entities.Employee;
import com.example.carRental.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static ModelMapper modelMapper;

    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = mapperToEmployee(employeeDto);
        Employee employeeOut = employeeRepository.save(employee);
        return mapEmployeeToEmployeeDto(employeeOut);
    }

    public List<EmployeeDto> getEmployees() {
        List<EmployeeDto> employeeDtoListList = employeeRepository.findAll().stream()
                .map(employee -> {
                    EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getLogin(), employee.getFirstname(),
                            employee.getLastname(), employee.getAuthority(), employee.getPassword(), employee.getBranch());
                    return employeeDto;
                })
                .collect(Collectors.toList());
        return employeeDtoListList;
    }

    private EmployeeDto mapEmployeeToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }

    private Employee mapperToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getLogin(), employeeDto.getFirstname(), employeeDto.getLastname(),
                employeeDto.getAuthority(), employeeDto.getPassword(), employeeDto.getBranch());
        return employee;
    }


    public Optional<Employee> getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional;
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = new Employee(id, employeeDto.getLogin(), employeeDto.getFirstname(), employeeDto.getLastname(),
                employeeDto.getAuthority(), employeeDto.getPassword(), employeeDto.getBranch());
        employeeRepository.save(employee);
    }
}
