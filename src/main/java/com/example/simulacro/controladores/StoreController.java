package com.example.simulacro.controladores;

import com.example.simulacro.entidades.Film;
import com.example.simulacro.entidades.Store;
import com.example.simulacro.servicios.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/{storeId}")
    public ResponseEntity<Store> findById(@PathVariable("storeId") int storeId) {
        try {
            Store s = storeService.findById(storeId);
            return ResponseEntity.ok(s);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Store> add(@RequestBody Store entity) {
        Store s = storeService.add(entity);
        return ResponseEntity.ok(s);
    }

    @PutMapping
    public ResponseEntity<Store> modify(@RequestBody Store entity) {
        try {
            Store s = storeService.modify(entity);
            return ResponseEntity.ok(s);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{storeId}")
    public ResponseEntity<Store> delete(@PathVariable("storeId") int storeId) {
        try {
            Store s = storeService.delete(storeId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
