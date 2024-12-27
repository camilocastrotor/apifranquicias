package com.api.prueba.user.franquicia.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

}
