package com.example.carRental.services;

import java.util.List;
import java.util.Optional;

public interface DefaultService<T>{
    T add(T t);

    List<T> get();

    Optional<T> findById(Long id);

    void delete(Long id);

    void updateById(Long id, T t);
}
