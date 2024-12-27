package com.api.prueba.user.franquicia.model.dto;

import lombok.Data;

import java.util.List;
@Data
public class FranchiseDTO {
    private Long id;
    private String name;
    private List<BranchDTO> branches;

    public FranchiseDTO(Long id, String name) {
        this.id=id;
        this.name=name;
    }

    public FranchiseDTO() {

    }


    // Getters y Setters
}
