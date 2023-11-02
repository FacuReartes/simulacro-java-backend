package com.example.simulacro.servicios;

import com.example.simulacro.entidades.Address;
import com.example.simulacro.repositorios.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    public AddressRepository addressRepository;

    @Override
    public Address add(Address entity) {
        int maxId = addressRepository.getMaxId();
        entity.setAddressId(maxId + 1);
        addressRepository.save(entity);
        return entity;
    }

    @Override
    public Address modify(Address entity) throws NoSuchElementException {
        Address existing = addressRepository.findById((int) entity.getAddressId()).orElseThrow();
        existing.setAddress(entity.getAddress());
        existing.setAddress2(entity.getAddress2());
        addressRepository.save(existing);
        return existing;
    }

    @Override
    public Address findById(int addressId) {
        return addressRepository.findById(addressId).orElseThrow();
    }

    @Override
    public Address delete(int addressId) {
        Address existing = addressRepository.findById(addressId).orElseThrow();
        addressRepository.delete(existing);
        return existing;
    }


}
