package com.example.carRental.configs;

import com.example.carRental.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/registration/**", "/api/login/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/cars/{id}").hasAnyAuthority("EMPLOYEE", "ADMIN", "USER")
                .antMatchers("/api/car_rentals/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/**").hasAnyAuthority("ADMIN", "EMPLOYEE")
                .antMatchers(HttpMethod.POST, "/api/**").hasAnyAuthority("ADMIN", "EMPLOYEE")
                .antMatchers(HttpMethod.PUT, "/api/reservations").hasAnyAuthority("ADMIN", "EMPLOYEE")
                .antMatchers(HttpMethod.PUT, "/api/**").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/**").hasAuthority("ADMIN")
                .antMatchers("/api/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userService);
        return provider;
    }
}
