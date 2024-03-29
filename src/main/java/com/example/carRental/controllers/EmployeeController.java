package com.example.carRental.controllers;

import com.example.carRental.dtos.EmployeeDto;
import com.example.carRental.entities.Branch;
import com.example.carRental.entities.Employee;
import com.example.carRental.repositories.BranchRepository;
import com.example.carRental.repositories.EmployeeRepository;
import com.example.carRental.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    private EmployeeRepository employeeRepository;

    private BranchRepository branchRepository;


    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository,
                              BranchRepository branchRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        this.branchRepository = branchRepository;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>>getEmployees(){
        List<EmployeeDto> employeeDtoList = employeeService.getEmployees();
        return  ResponseEntity.ok(employeeDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id){
        Optional<Employee> employeeOptional = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeOptional);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{employeeId}/branch/{branchId}")
    public Employee addEmployeeToBranch(@PathVariable Long employeeId, @PathVariable Long branchId){
        Employee employee = employeeRepository.findById(employeeId).get();
        Branch branch = branchRepository.findById(branchId).get();

        employee.setBranch(branch);
        return employeeRepository.save(employee);



    }
}
