package com.example.simulacro.repositorios;

import com.example.simulacro.entidades.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

    @Query("SELECT coalesce(max(storeId), 0) FROM Store")
    Integer getMaxId();

}
