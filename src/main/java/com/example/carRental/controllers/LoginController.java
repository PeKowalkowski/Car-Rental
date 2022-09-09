package com.example.carRental.controllers;

import com.example.carRental.dtos.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<HttpStatus> login(@RequestBody EmployeeDto employeeDto) throws Exception {
        Authentication auth;
        try {
        auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(employeeDto.getLogin(),
                employeeDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(auth);
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials");
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}
