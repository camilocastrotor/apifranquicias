package com.api.prueba.user.franquicia.controller;

import com.api.prueba.user.franquicia.model.dto.BranchDTO;
import com.api.prueba.user.franquicia.model.dto.FranchiseDTO;
import com.api.prueba.user.franquicia.model.dto.ProductDTO;
import com.api.prueba.user.franquicia.model.dto.TopProductDTO;
import com.api.prueba.user.franquicia.services.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franchises")
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    @PostMapping
    public FranchiseDTO addFranchise(@RequestBody FranchiseDTO franchiseDTO) {
        return franchiseService.addFranchise(franchiseDTO);
    }

    @PutMapping("/franchise/{id}/name")
    public ResponseEntity<FranchiseDTO> updateFranchiseName(@PathVariable Long id, @RequestBody String newName) {
        FranchiseDTO updatedFranchise = franchiseService.updateFranchiseName(id, newName);
        return ResponseEntity.ok(updatedFranchise);
    }
}
