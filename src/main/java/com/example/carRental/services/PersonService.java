package com.example.carRental.services;

import com.example.carRental.dtos.PersonDto;
import com.example.carRental.entities.Person;
import com.example.carRental.enums.Role;
import com.example.carRental.repositories.PersonRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService implements UserDetailsService {


    private PersonRepository personRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public PersonService(PersonRepository personRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.personRepository = personRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return personRepository.findByLogin(login).orElseThrow(() ->
                new UsernameNotFoundException("Nie ma"));
    }

    public Person signUpPerson(Person person){
        boolean personExist = personRepository.findByLogin(person.getLogin()).isPresent();

        if(personExist){
            throw new IllegalStateException("Zajety");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(person.getPassword());

        person.setPassword(encodedPassword);


        personRepository.save(person);

        return person;


    }
    public List<PersonDto> getPersons() {
        List<PersonDto> personDtoList = personRepository.findAll().stream()
                .map(person -> {
                    PersonDto PersonDto = new PersonDto(person.getId(), person.getLogin(), person.getFirstname(),
                            person.getLastname(),person.getPesel(),person.getAddress(), person.getRole());
                    return PersonDto;
                })
                .collect(Collectors.toList());
        return personDtoList;
    }

    public Optional<Person> getPersonById(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personOptional;
    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

    public void updatePerson(Long id, PersonDto personDto) {
            Person person = new Person(id, personDto.getLogin(), personDto.getFirstname(), personDto.getLastname(),
                    personDto.getPassword(), personDto.getPesel(),Role.valueOf(String.valueOf(personDto.getRole())));
            personRepository.save(person);
        }




}
