package com.api.prueba.user.franquicia.model.dto;

import lombok.Data;

@Data
public class TopProductDTO {
    private String branchName;
    private ProductDTO product;

    public TopProductDTO(String branchName, ProductDTO product) {
        this.branchName = branchName;
        this.product = product;
    }
    // Constructor, Getters y Setters
}