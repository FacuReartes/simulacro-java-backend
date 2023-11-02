package com.example.simulacro.controladores;

import com.example.simulacro.entidades.Customer;
import com.example.simulacro.entidades.Inventory;
import com.example.simulacro.servicios.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{inventoryId}")
    public ResponseEntity<Inventory> findById(@PathVariable("inventoryId") int inventoryId) {
        try {
            Inventory i = inventoryService.findById(inventoryId);
            return ResponseEntity.ok(i);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Inventory> add(@RequestBody Inventory entity) {
        Inventory i = inventoryService.add(entity);
        return ResponseEntity.ok(i);
    }

    @DeleteMapping("/{inventoryId}")
    public ResponseEntity<Inventory> delete(@PathVariable("inventoryId") int inventoryId) {
        try {
            Inventory i = inventoryService.delete(inventoryId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<Inventory> modify(@RequestBody Inventory entity) {
        try {
            Inventory i = inventoryService.modify(entity);
            return ResponseEntity.ok(i);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
