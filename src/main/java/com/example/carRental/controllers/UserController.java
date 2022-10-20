
package com.example.carRental.controllers;

import com.example.carRental.dtos.EmployeeDto;
import com.example.carRental.dtos.UserDto;
import com.example.carRental.servicesImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        userService.updateUser(id, userDto);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<UserDto>>getUsers(){
        List<UserDto> userDtoList = userService.getUsers();
        return  ResponseEntity.ok(userDtoList);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}

