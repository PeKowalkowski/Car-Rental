package com.example.carRental.services;

import com.example.carRental.dtos.UserDto;
import com.example.carRental.entities.User;
import com.example.carRental.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login).orElseThrow(() ->
                new UsernameNotFoundException("Nie ma"));
    }

    public String signUpUser(User user){
        boolean userExist = userRepository.findByLogin(user.getLogin()).isPresent();

        if(userExist){
            throw new IllegalStateException("Zajety");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);


        userRepository.save(user);

        return "Succes";


    }

    public void updateUser(Long id, UserDto userDto) {
        User user = new User(id, userDto.getLogin(), userDto.getFirstname(), userDto.getLastname(),
                userDto.getPassword(),userDto.getRole());
        userRepository.save(user);
    }

    public List<UserDto> getUsers() {
        List<UserDto> userDtoList = userRepository.findAll().stream()
                .map(user -> {
                    UserDto userDto = new UserDto(user.getId(), user.getLogin(), user.getFirstname(),
                            user.getLastname(), user.getPassword(),user.getRole(), user.getAddress());
                    return userDto;
                })
                .collect(Collectors.toList());
        return userDtoList;
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
