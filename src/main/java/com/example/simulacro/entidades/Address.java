package com.example.simulacro.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    private long addressId;

    @Basic
    private String address;

    @Basic
    private String address2;

    @Basic
    private String district;

    @Column(name = "city_id")
    private int cityId;

    @Column(name = "postal_code")
    private String postalCode;


    private String phone;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}

