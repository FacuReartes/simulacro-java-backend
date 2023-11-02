package com.example.simulacro.entidades.dto;

import com.example.simulacro.entidades.Address;
import com.example.simulacro.entidades.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private long storeId;
    private long addressId;

}
