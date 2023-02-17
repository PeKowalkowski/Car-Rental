
package com.example.carRental.controllers;

import com.example.carRental.dtos.PersonDto;
import com.example.carRental.entities.Person;
import com.example.carRental.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {


    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getPersons(){
        List<PersonDto> personDtoList = personService.getPersons();
        return  ResponseEntity.ok(personDtoList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getPersonById(@PathVariable Long id){
        Optional<Person> personOptional = personService.getPersonById(id);
        return ResponseEntity.ok(personOptional);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonById(@PathVariable Long id){
        personService.deletePersonById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable Long id, @RequestBody PersonDto personDto){
        personService.updatePerson(id, personDto);
        return ResponseEntity.noContent().build();
    }
}

