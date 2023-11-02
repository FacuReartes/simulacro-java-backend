package com.example.simulacro.controladores;

import com.example.simulacro.entidades.Customer;
import com.example.simulacro.entidades.Film;
import com.example.simulacro.entidades.Store;
import com.example.simulacro.entidades.dto.CustomerDto;
import com.example.simulacro.servicios.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> findById(@PathVariable("customerId") int customerId) {
        try {
            CustomerDto c = customerService.findById(customerId);
            return ResponseEntity.ok(c);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CustomerDto> add(@RequestBody CustomerDto entity) {
        CustomerDto c = customerService.add(entity);
        return ResponseEntity.ok(c);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> delete(@PathVariable("customerId") int customerId) {
        try {
            customerService.delete(customerId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<CustomerDto> modify(@RequestBody CustomerDto entity) {
        try {
            CustomerDto c = customerService.modify(entity);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(c);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{customerId}/localStores")
    public ResponseEntity<List<Store>> findLocalStores(@PathVariable("customerId") int customerId) {
        try {
            List<Store> storeList = customerService.findLocalStores(customerId);
            return ResponseEntity.ok(storeList);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
