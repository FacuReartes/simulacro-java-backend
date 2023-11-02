package com.example.simulacro.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    private long inventoryId;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film filmId;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store storeId;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
