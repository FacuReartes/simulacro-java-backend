package com.example.simulacro.repositorios;

import com.example.simulacro.entidades.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT coalesce(max(addressId), 0) FROM Address")
    Integer getMaxId();

}
