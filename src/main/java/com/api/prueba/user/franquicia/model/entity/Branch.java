package com.api.prueba.user.franquicia.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branch")
    private List<Product> products;

    // Getters, Setters, Constructor
}
