package com.example.simulacro.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "store")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    private long storeId;

    @Column(name = "manager_staff_id")
    private long managerStaffId;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address addressId;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
