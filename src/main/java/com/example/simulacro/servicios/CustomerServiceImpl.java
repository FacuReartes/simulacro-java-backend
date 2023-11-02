package com.example.simulacro.servicios;

import com.example.simulacro.entidades.Customer;
import com.example.simulacro.entidades.Film;
import com.example.simulacro.entidades.Store;
import com.example.simulacro.entidades.dto.CustomerDto;
import com.example.simulacro.repositorios.AddressRepository;
import com.example.simulacro.repositorios.CustomerRepository;
import com.example.simulacro.repositorios.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public AddressRepository addressRepository;

    @Autowired
    public StoreRepository storeRepository;

    @Autowired
    public StoreService storeService;

    @Override
    public CustomerDto add(CustomerDto customerDto) {
        int maxId = customerRepository.getMaxId();
        Customer entity = convertToEntity(customerDto);
        entity.setCustomerId(maxId + 1);
        customerRepository.save(entity);
        return convertToDto(entity);
    }

    @Override
    public CustomerDto modify(CustomerDto customerDto) throws NoSuchElementException {
        Customer existing = customerRepository.findById((int) customerDto.getCustomerId()).orElseThrow();
        existing.setFirstName(customerDto.getFirstName());
        existing.setLastName(customerDto.getLastName());
        customerRepository.save(existing);
        return convertToDto(existing);
    }

    @Override
    public CustomerDto findById(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return customer.map(this::convertToDto).orElse(null);
    }

    @Override
    public void delete(int customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public CustomerDto convertToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(customer.getCustomerId());
        customerDto.setStoreId(customer.getStore().getStoreId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setActive(customer.isActive());
        customerDto.setCreateDate(customer.getCreateDate());
        customerDto.setLastUpdate(customer.getLastUpdate());
        customerDto.setAddressId(customer.getAddress().getAddressId());
        return customerDto;
    }

    @Override
    public Customer convertToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCustomerId(customerDto.getCustomerId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setActive(customerDto.isActive());
        customer.setCreateDate(customerDto.getCreateDate());
        customer.setLastUpdate(customerDto.getLastUpdate());
        customer.setStore(storeRepository.findById((int) customerDto.getStoreId()).orElseThrow());
        customer.setAddress(addressRepository.findById((int) customerDto.getAddressId()).orElseThrow());
        return customer;
    }

    @Override
    public List<Store> findLocalStores(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        int cityId = customer.getAddress().getCityId();
        return storeService.findAllByCityId(cityId);
    }
}
