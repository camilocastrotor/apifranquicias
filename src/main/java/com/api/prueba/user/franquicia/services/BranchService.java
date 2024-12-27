package com.api.prueba.user.franquicia.services;

import com.api.prueba.user.common.exception.ResourceNotFoundException;
import com.api.prueba.user.franquicia.model.dto.BranchDTO;
import com.api.prueba.user.franquicia.model.dto.FranchiseDTO;
import com.api.prueba.user.franquicia.model.dto.ProductDTO;
import com.api.prueba.user.franquicia.model.dto.TopProductDTO;
import com.api.prueba.user.franquicia.model.entity.Branch;
import com.api.prueba.user.franquicia.model.entity.Franchise;
import com.api.prueba.user.franquicia.model.entity.Product;
import com.api.prueba.user.franquicia.repository.BranchRepository;
import com.api.prueba.user.franquicia.repository.FranchiseRepository;
import com.api.prueba.user.franquicia.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchService {


    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public BranchDTO addBranch(Long franchiseId, BranchDTO branchDTO) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Franchise not found"));
        Branch branch = modelMapper.map(branchDTO, Branch.class);
        branch.setFranchise(franchise);
        Branch savedBranch = branchRepository.save(branch);
        return modelMapper.map(savedBranch, BranchDTO.class);
    }
    public BranchDTO updateBranchName(Long id, String newName) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found"));

        branch.setName(newName);
        branchRepository.save(branch);

        return new BranchDTO(branch.getId(), branch.getName());
    }

}

