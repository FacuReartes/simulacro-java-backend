package com.example.simulacro.controladores;

import com.example.simulacro.entidades.Address;
import com.example.simulacro.servicios.AddressService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> findById(@PathVariable("addressId") int addressId) {
        try {
            Address a = addressService.findById(addressId);
            return ResponseEntity.ok(a);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Address> add(@RequestBody Address entity) {
        Address a = addressService.add(entity);
        return ResponseEntity.ok(a);
    }

    @PutMapping
    public ResponseEntity<Address> update(@RequestBody Address entity) {
        try {
            Address a = addressService.modify(entity);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(a);
        } catch(NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Address> delete(@PathVariable("addressId") int addressId) {
        try {
            Address a = addressService.delete(addressId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(a);
        } catch(NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
