package com.example.simulacro.servicios;

import com.example.simulacro.entidades.Inventory;

import java.util.NoSuchElementException;

public interface InventoryService {

    Inventory add(Inventory entity);

    Inventory findById(int inventoryId);

    Inventory delete(int inventoryId);

    Inventory modify(Inventory entity) throws NoSuchElementException;

}
