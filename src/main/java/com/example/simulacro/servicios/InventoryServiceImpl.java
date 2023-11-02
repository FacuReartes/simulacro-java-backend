package com.example.simulacro.servicios;

import com.example.simulacro.entidades.Inventory;
import com.example.simulacro.repositorios.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    public InventoryRepository inventoryRepository;

    @Override
    public Inventory add(Inventory entity) {
        int maxId = inventoryRepository.getMaxId();
        entity.setInventoryId(maxId + 1);
        inventoryRepository.save(entity);
        return entity;
    }

    @Override
    public Inventory findById(int inventoryId) {
        return inventoryRepository.findById(inventoryId).orElseThrow();
    }

    @Override
    public Inventory delete(int inventoryId) {
        Inventory existing = inventoryRepository.findById(inventoryId).orElseThrow();
        inventoryRepository.delete(existing);
        return existing;
    }

    @Override
    public Inventory modify(Inventory entity) throws NoSuchElementException {
        Inventory existing = inventoryRepository.findById((int) entity.getInventoryId()).orElseThrow();
        // existing.setFilmId(entity.getFilmId());
        inventoryRepository.save(existing);
        return existing;
    }
}
