package com.api.prueba.user.franquicia.model.dto;

import lombok.Data;

import java.util.List;
@Data
public class BranchDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;

    public BranchDTO(Long id, String name) {
        this.id=id;
        this.name=name;
    }

    public BranchDTO() {

    }
}
