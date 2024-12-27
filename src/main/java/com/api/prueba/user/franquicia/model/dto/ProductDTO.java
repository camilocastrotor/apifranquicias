package com.api.prueba.user.franquicia.model.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private int stock;

    public ProductDTO(Long id, String name, int stock) {
        this.id=id;
        this.name=name;
        this.stock=stock;
    }
    public ProductDTO() {

    }
}
