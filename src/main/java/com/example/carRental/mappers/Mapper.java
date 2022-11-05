package com.example.carRental.mappers;

public interface Mapper <E,D>{


    public D mapperEntityToDto(E e);

    public E mapperDtoToEntity(D d);
}
