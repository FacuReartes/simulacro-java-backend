package com.example.simulacro.servicios;

import com.example.simulacro.entidades.Address;

import java.util.NoSuchElementException;

public interface AddressService {

    Address add(Address entity);

    Address modify(Address entity) throws NoSuchElementException;

    Address findById(int addressId);

    Address delete(int addressId);
}
