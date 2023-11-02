package com.example.simulacro.repositorios;

import com.example.simulacro.entidades.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT coalesce(max(customerId), 0) FROM Customer")
    Integer getMaxId();

}
