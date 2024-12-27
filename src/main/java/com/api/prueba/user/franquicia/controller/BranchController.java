package com.api.prueba.user.franquicia.controller;

import com.api.prueba.user.franquicia.model.dto.BranchDTO;
import com.api.prueba.user.franquicia.model.dto.FranchiseDTO;
import com.api.prueba.user.franquicia.model.dto.ProductDTO;
import com.api.prueba.user.franquicia.model.dto.TopProductDTO;
import com.api.prueba.user.franquicia.services.BranchService;
import com.api.prueba.user.franquicia.services.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franchises")
public class BranchController {

    @Autowired
    private BranchService branchService;


    @PostMapping("/{franchiseId}/branches")
    public BranchDTO addBranch(@PathVariable Long franchiseId, @RequestBody BranchDTO branchDTO) {
        return branchService.addBranch(franchiseId, branchDTO);
    }

    @PutMapping("/branches/{id}/name")
    public ResponseEntity<BranchDTO> updateBranchName(@PathVariable Long id, @RequestBody String newName) {
        BranchDTO updatedBranch = branchService.updateBranchName(id, newName);
        return ResponseEntity.ok(updatedBranch);
    }

}
