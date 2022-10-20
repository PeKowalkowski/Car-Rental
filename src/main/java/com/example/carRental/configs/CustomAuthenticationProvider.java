/*
package com.example.carRental.configs;

import com.example.carRental.entities.Authority;
import com.example.carRental.entities.Employee;

*/
/*
import com.example.carRental.entities.User;
*//*

import com.example.carRental.repositories.EmployeeRepository;

*/
/*
import com.example.carRental.repositories.UserRepository;
*//*

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        Employee employee = employeeRepository.findByLogin(login).orElseThrow(() ->
                new UsernameNotFoundException("Employee not found"));

        if(passwordEncoder.matches(password, employee.getPassword())){
            List<GrantedAuthority> authorityList = new ArrayList<>();

            authorityList.add(new SimpleGrantedAuthority(employee.getAuthority().getAuthority()));
            return new UsernamePasswordAuthenticationToken(login, password, authorityList);
        }else {
            throw new BadCredentialsException("Invalid Credentials");
        }
    }

   */
/* @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userRepository.findByLogin(login).orElseThrow(() ->
                new UsernameNotFoundException("Employee not found"));

        if (passwordEncoder.matches(password, user.getPassword())) {
            List<GrantedAuthority> authorityList = new ArrayList<>();

            authorityList.add(new SimpleGrantedAuthority(user.getAuthority().getAuthority()));
            return new UsernamePasswordAuthenticationToken(login, password, authorityList);
        } else {
            throw new BadCredentialsException("Invalid Credentials");
        }
    }*//*




    */
/*private Set<SimpleGrantedAuthority> getAuthorities(Set<Authority> authority) {
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        for(Authority auth : authority){
            boolean add = grantedAuthorities.add(new SimpleGrantedAuthority(auth.g);
        }
        return grantedAuthorities;
    }*//*


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}


*/
