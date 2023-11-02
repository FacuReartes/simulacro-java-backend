package com.example.simulacro.servicios;

import com.example.simulacro.entidades.Customer;
import com.example.simulacro.entidades.Store;
import com.example.simulacro.entidades.dto.CustomerDto;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public interface CustomerService {

    CustomerDto add(CustomerDto entity);

    CustomerDto modify(CustomerDto entity) throws NoSuchElementException;

    CustomerDto findById(int customerId);

    void delete(int customerId);

    CustomerDto convertToDto(Customer customer);

    Customer convertToEntity(CustomerDto customerDto);

    List<Store> findLocalStores(int customerId);
}
