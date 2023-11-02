package com.example.simulacro.repositorios;

import com.example.simulacro.entidades.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    @Query("SELECT coalesce(max(inventoryId), 0) FROM Inventory")
    Integer getMaxId();

}
